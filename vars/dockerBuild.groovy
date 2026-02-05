def call() {
    sh 'docker compose -f Docker-Compose-Projects/docker-compose.build.yml build'
}

