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
                sh "chmod 700 gradlew && ./gradlew clean build"
            }
        }
        stage("Artifactory Publish") {
            steps {
                withCredentials([string(credentialsId: 'docker-registry-url', variable: 'docker_registry_url')]) {
                    sh "docker build . -t spring-boot-demo"
                    sh "docker tag  spring-boot-demo $docker_registry_url/spring-boot-demo"
                    sh "docker push $docker_registry_url/spring-boot-demo"
                }
            }
        }
        post {
            always {
                jacoco exclusionPattern: '**/test/**'
            }
        }


    }
}
