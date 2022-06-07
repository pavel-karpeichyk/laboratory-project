
pipeline {
  agent any
  options {
    timestamps()
  }
  tools {
   
    gradle 'Gradle'
  }

  stages {
    stage('Build Tests') {
      steps {
        "echo Start internal test gradle clean -i test --tests "
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
