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

    post {// read about this section add gradle and junit report
      always {
        junit 'build/test-results/**/*.xml'
        allure([
            includeProperties: false,
            jdk              : '',
            properties       : [],
            reportBuildPolicy: 'ALWAYS',
            results          : [[path:"/build/allure-results"]]
        ])
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