pipeline {
  agent none
  options {
    ansiColor('xterm')
    disableConcurrentBuilds()
    disableResume()
    buildDiscarder(logRotator(daysToKeepStr: "1"))
  }
  stages {
    stage('test') {
      agent {
        docker {
          image 'centos:latest'
        }
      }
      steps {
        script {
          sh """
            : "\033[91m --- INFO --- \033[0m"
            env
          """
        }
      } // END steps
    } // END stage
  } // END stages
} // END pipeline
