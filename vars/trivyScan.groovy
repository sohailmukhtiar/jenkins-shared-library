def call(String imageTag) {
    sh """
    mkdir -p trivy-reports

    trivy image \
      --severity LOW,MEDIUM,HIGH,CRITICAL \
      --format json \
      -o trivy-reports/backend.json \
      sohail185/backend-app:${imageTag} || true

    trivy image \
      --severity LOW,MEDIUM,HIGH,CRITICAL \
      --format json \
      -o trivy-reports/frontend.json \
      sohail185/frontend-app:${imageTag} || true
    """
}

