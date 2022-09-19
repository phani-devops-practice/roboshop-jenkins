pipeline {
  agent any
  options {
    ansiColor('xterm')
  }
  stages {
    stage('Create Jobs') {
      steps {
        sh 'ansible-playbook create-jobs.yml'
      }
    }
  }
}