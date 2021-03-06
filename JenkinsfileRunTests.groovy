static String startRunTestSuite() {
  return """
            echo Start internal test
              gradle clean -i test --tests BorrowerVerificationTest       
  """
}

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
        bat startRunTestSuite()
      }
    }
  }

    post {
      always {
        junit '**/build/test-results/test/*.xml'
        allure([
            includeProperties: false,
            jdk              : '',
            properties       : [],
            reportBuildPolicy: 'ALWAYS',
            results          : [[path:"/build/allure-results"]]
        ])}
      failure {
        publishHTML([
            reportDir            : "build/reports/tests/test",
            reportFiles          : 'index.html',
            reportName           : "Gradle Test Report",
            allowMissing         : true,
            alwaysLinkToLastBuild: true,
            keepAll              : true])
      }
    }
  }