static String startRunTestSuite() {
  return """
            echo Start internal test
              gradle clean -i test --tests ApplicationPropertiesTest
              
  """
}

pipeline {
  agent any

  tools {
    jdk 'jdk 1.8'
    gradle 'Gradle'
  }

  stages {
    stage('Build Tests') {
      steps {
        bat startRunTestSuite()
      }
    }
  }

  post {
    always {
      archiveArtifacts artifacts: '**/*.jar', fingerprint: true
      junit 'build/test-results/**/*.xml'
      publishHTML([
          reportDir            : "build/reports/tests/test",
          reportFiles          : 'index.html',
          reportName           : "Gradle Test Report",
          allowMissing         : true,
          alwaysLinkToLastBuild: true,
          keepAll              : true]
      )
    }
  }
}