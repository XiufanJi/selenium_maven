pipeline {
  agent any
  stages {
    stage('clone codes') {
      steps {
        git(url: 'https://github.com/XiufanJi/selenium_maven.git', branch: 'master')
      }
    }

    stage('test') {
      steps {
        sh '''#!/bin/bash
echo "begin test!"
mvn package'''
      }
    }

    stage('result') {
      steps {
        archiveArtifacts 'target/*.jar'
      }
    }

  }
}