pipeline {
  agent any
  stages {
    stage('clone codes') {
      steps {
        git(url: 'https://github.com/XiufanJi/selenium_maven.git', branch: 'master', changelog: true)
      }
    }

    stage('test') {
      steps {
        sh 'echo"begin test"'
        sh 'mvn package'
      }
    }

    stage('result') {
      steps {
        junit 'target/*.xml'
        archiveArtifacts(artifacts: 'target/*.jar', onlyIfSuccessful: true, fingerprint: true)
      }
    }

  }
}