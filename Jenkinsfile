pipeline {
    agent any
    tools {
        maven 'Maven 3.6.3'
    }
    stages {
        stage('Build') {
            steps {
                echo 'String Operator'
                sh 'java --version'
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('package') {
            steps {
                sh 'mvn package'
            }
        }
        stage('Build image') {
                    /* This builds the actual image; synonymous to
                    * docker build on the command line */
                    app = docker.build("string-operator")
                    }
                stage('Push image') {
                    /* Finally, we'll push the image with two tags:
                     * First, the incremental build number from Jenkins
                     * Second, the 'latest' tag.
                     * Pushing multiple tags is cheap, as all the layers are reused. */
                    docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
                        app.push("${env.BUILD_NUMBER}")
                        app.push("latest")
                    }
                }
    }

}