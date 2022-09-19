pipeline {
  agent any
  stages {
    stage('Create Jobs') {
      steps {
        sh 'ansible-playbook create-jobs.yml'
      }
    }
  }
}