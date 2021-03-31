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
                sh 'mvn clean compile'
            }
        }
        stage('Test'){
            steps {
                sh 'mvn test'
            }
        }

        stage('Build Image'){
            when {
                branch 'master'
            }
            steps {
                sh 'mvn package'
                sh 'docker build -t milanarif/string-operator .'
            }
            post {
                success {
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        stage('Run Image') {
            when {
                branch 'master'
            }
            steps {
                sh 'docker run milanarif/string-operator'
            }
        }
        stage('Push Image') {
            when {
                branch 'master'
            }
            steps {
                sh 'docker login --username=${DOCKERHUB_USERNAME} --password=${DOCKERHUB_PASSWORD}'
                sh 'docker push milanarif/string-operator'
            }
        }
    }
}