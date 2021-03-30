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
                /* This builds the actual image; synonymous to
                 * docker build on the command line */

                app = docker.build("stringoperator/stringop")
        }
        stage('Push image') {
            docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                        app.push("${env.BUILD_NUMBER}")
                        app.push("latest")
            }
        }
    }
}
