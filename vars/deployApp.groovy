def call(String imageTag) {
    sshagent(['prod-ssh-key']) {
        sh """
        scp Docker-Compose-Projects/docker-compose.deploy.yml root@192.168.217.224:/app/
        ssh root@192.168.217.224 '
            cd /app
            export IMAGE_TAG=${imageTag}
            docker compose -f docker-compose.deploy.yml pull
            docker compose -f docker-compose.deploy.yml up -d
        '
        """
    }
}

