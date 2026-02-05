def call(String imageTag) {
    withCredentials([
        usernamePassword(
            credentialsId: 'dockerhub-credentials',
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )
    ]) {
        sh """
        echo "\$DOCKER_PASS" | docker login -u "\$DOCKER_USER" --password-stdin
        docker push sohail185/backend-app:${imageTag}
        docker push sohail185/frontend-app:${imageTag}
        """
    }
}

