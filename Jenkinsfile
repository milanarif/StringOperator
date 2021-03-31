pipeline {
    agent any
    tools{
        maven 'Maven 3.6.3'
    }
    environment {
        DOCKERHUB_PASSWORD = credentials('dh-pass')
        DOCKERHUB_USERNAME = credentials ('dh-username')
    }
    stages {
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
                script {
                    if (true) {
                        sh 'mvn package'
                        sh 'docker --version'
                        sh 'docker build -t milanarif/string-operator .'
                        archiveArtifacts artifacts: 'target/*.jar'
                    }
                }
            }
        }
        stage('Run Image') {
            steps {
                script {
                    def pom = new File('/var/jenkins_home/workspace/StringOperator_master/pom.xml').getText('utf-8')
                    def doc = new XmlParser().parseText(pom)
                    def version = attributes()['version']
                    if (version.contains('SNAPSHOT')) {
                        sh 'docker run milanarif/string-operator'
                    }
                }
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