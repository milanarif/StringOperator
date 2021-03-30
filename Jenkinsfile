pipeline{
    agent any
    tools{
        maven 'Maven 3.6.3'
    }

    stages{
        stage('Build'){
            steps {
                echo 'Hello'
                sh 'java -version'
                sh 'mvn clean compile'
            }
        }
        stage('Test'){
            steps {
                sh 'mvn test'
            }
        }
        stage('Build image') {
            steps {
                script {
                    dockerImage = docker.build("string-operator")
                }
            }
        }
        stage('Push image') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                        dockerImage.push()
                    }
                }
            }
        }
    }
}
