def call(String branch) {
    checkout([
        $class: 'GitSCM',
        branches: [[name: "*/${branch}"]],
        userRemoteConfigs: [[
            url: 'https://github.com/sohailmukhtiar/School-app.git'
        ]]
    ])
}

