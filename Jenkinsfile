pipeline {
  agent any
  stages {
    stage('Create Jobs') {
      sh 'ansible-playbook create-jobs.yml'
    }
  }
}