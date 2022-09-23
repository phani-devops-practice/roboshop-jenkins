pipeline {
  agent any

  parameters {
    string(name: 'COMPONENT', defaultValue: '', description: 'Which Component')
    string(name: 'ENV', defaultValue: '', description: 'Which Env')
    string(name: 'APP_VERSION', defaultValue: '', description: 'Which App version')
  }

  environment {
    SSH = credentials("SSH")
  }

  stages {
    stage('Clone Repo') {
      steps {
        git branch: 'main', url: "https://github.com/phani-devops-practice/roboshop_ansible.git"
      }
    }
    stage('Deploy') {
      steps {
        sh """
          ansible-playbook -i ${COMPONENT}-${ENV}.roboshop.internal, -e HOST=${COMPONENT}-${ENV}.roboshop.internal -e ROLE=${COMPONENT} -e ansible_user=${SSH_USR}  -e ansible_password=${SSH_PSW} roboshop.yml -e ENV=${{ENV}} -e APP_VERSION=${APP_VERSION}
        """
      }
    }
  }
}