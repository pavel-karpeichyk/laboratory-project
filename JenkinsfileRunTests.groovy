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
        allure([
            includeProperties: false,
            jdk              : '',
            properties       : [],
            reportBuildPolicy: 'ALWAYS',
            results          : [[path:"/build/allure-results"]]
        ])
      }
    }
  }