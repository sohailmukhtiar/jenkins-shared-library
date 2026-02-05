def call() {
    withSonarQubeEnv('SonarQubeServer') {
        sh """
            ${tool 'SonarScanner'}/bin/sonar-scanner \
            -Dsonar.projectKey=school-app \
            -Dsonar.sources=./Docker-Compose-Projects
        """
    }
}

