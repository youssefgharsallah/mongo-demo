pipeline {
    agent any

    stages {
        stage('Build and Run') {
            steps {
                script {

                    sh 'docker build -t alidaoud/mongo-demo -f /home/jenkins/proj/Dockerfile /home/jenkins/proj'
                }
            }
        }

        stage('Push image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'alidaoud-dockerhub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
                    // Log in to Docker Hub
                    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"

                    // Push the Docker image to Docker Hub
                    sh 'docker push alidaoud/mongo-demo:latest'
                }
            }
        }
    }
}