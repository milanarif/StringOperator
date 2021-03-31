pipeline{
    agent any
    tools{
        maven 'Maven 3.6.3'
    }
    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-cred')
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
        stage('Deploy'){
            steps {
                sh 'mvn package'
                sh 'docker --version'
                sh 'docker build -t milanarif/string-operator .'
                sh (credentials-dockerhub)
                sh 'docker push milanarif/string-operator'
            }
            post {
                success {
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}