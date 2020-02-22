pipeline {
    agent { node { label 'backend'}}

    triggers {
        pollSCM 'H/2 * * * *'
    }
    options {
        disableConcurrentBuilds()
    }

    stages {
        stage("Checkout") {
            steps {
                git branch: "master",
                        url: 'https://github.com/qicaisheng/spring-boot-demo.git'
            }
        }
        stage("Build") {
            steps {
                sh "cd complete && chmod 700 gradlew && ./gradlew clean build"
            }
        }
    }
}
