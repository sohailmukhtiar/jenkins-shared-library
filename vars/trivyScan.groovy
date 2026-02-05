def call(String imageTag) {
    sh """
    mkdir -p trivy-reports

    echo "🔍 Scanning Backend Image (HTML + JSON)"
    trivy image \
      --severity LOW,MEDIUM,HIGH,CRITICAL \
      --format template \
      --template "@/var/lib/jenkins/trivy-templates/html.tpl" \
      -o trivy-reports/backend.html \
      sohail185/backend-app:${imageTag} || true

    trivy image \
      --severity LOW,MEDIUM,HIGH,CRITICAL \
      --format json \
      -o trivy-reports/backend.json \
      sohail185/backend-app:${imageTag} || true

    echo "🔍 Scanning Frontend Image (HTML + JSON)"
    trivy image \
      --severity LOW,MEDIUM,HIGH,CRITICAL \
      --format template \
      --template "@/var/lib/jenkins/trivy-templates/html.tpl" \
      -o trivy-reports/frontend.html \
      sohail185/frontend-app:${imageTag} || true

    trivy image \
      --severity LOW,MEDIUM,HIGH,CRITICAL \
      --format json \
      -o trivy-reports/frontend.json \
      sohail185/frontend-app:${imageTag} || true
    """
}
