pipeline{
    agent any
    tools{
        maven 'Maven 3.6.3'
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
                sh 'docker login --username milanarif'
                sh '729f6f03-ab78-4fba-b55d-0586c4d727a4'
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