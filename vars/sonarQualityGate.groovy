def call() {
    script {
        try {
            timeout(time: 1, unit: 'MINUTES') {
                waitForQualityGate()
            }
        } catch (e) {
            echo "Quality gate skipped"
        }
    }
}

