pipeline {
   agent any

       tools {
           maven 'Maven-3-9-6'
       }

    stages {
        stage('Checkout') {
            steps {
                script {
                    git 'https://github.com/alidaoud7/mongo-demo.git'

                }
            }
        }
        stage('Build') {
            steps {
                script {
                    sh 'mvn clean package -DskipTests'
                    // sh 'docker build -t alidaoud/mongo-demo /home/jenkins/proj'
                    sh 'docker build -t alidaoud/mongo-demo .'
                    }
            }
        }
        stage('Push image') {
                    steps {
                withCredentials([usernamePassword(credentialsId: 'alidaoud-dockerhub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
                    // Log in to Docker Hub
                    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"

                    sh 'docker push app/mongo-demo:latest'
                    }
                }


    } // Stages
}  // Pipeline