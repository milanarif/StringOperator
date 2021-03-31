pipeline {
    node {
        agent any
        tools{
            maven 'Maven 3.6.3'
        }
        environment {
            DOCKERHUB_PASSWORD = credentials('dh-pass')
            DOCKERHUB_USERNAME = credentials ('dh-username')
        }
        stages{
            stage('Build'){
                steps {
                    echo 'Hello World'
                    sh 'java -version'
                    sh 'mvn clean compile'
                }
            }
            stage('Test'){
                steps {
                    sh 'mvn test'
                }
            }

            stage('Build Image'){
                steps {
                    sh 'mvn package'
                    sh 'docker --version'
                    sh 'docker build -t milanarif/string-operator .'
                }
                post {
                    success {
                        archiveArtifacts 'target/*.jar'
                    }
                }
            }
            stage('Run Image') {
                steps {
                    sh 'docker run milanarif/string-operator'
                }

            }
            stage('Push Image') {
                steps {
                    sh 'docker login --username=${DOCKERHUB_USERNAME} --password=${DOCKERHUB_PASSWORD}'
                    sh 'docker push milanarif/string-operator'
                }
            }
        }
    }
}