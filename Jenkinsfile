pipeline {
    agent any

    tools {
        maven 'Maven-3-9-6'
    }

    stages {
//         stage('Checkout') {
//             steps {
//                 script {
//                     git 'https://github.com/alidaoud7/mongo-demo.git'
//                 }
//             }
//         }

//         stage('Build') {
//             steps {
//                 script {
//                  //   sh 'mvn test'
//                     sh 'mvn clean package -DskipTests'
//                     sh 'docker build -t alidaoud/mongo-demo .'
//                 }
//             }
//         }

//         stage('SonarQube Analysis') {
//             steps {
//                 script {
//                     withSonarQubeEnv('sonarqube-server') {
//                         sh 'mvn sonar:sonar'
//                     }
//                 }
//             }
//         }

//         stage('Push image') {
//             steps {
//                 withCredentials([usernamePassword(credentialsId: 'alidaoud-dockerhub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
//                     sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
//                     sh 'docker push alidaoud/mongo-demo:latest'
//                 }
//             }
//         }
        stage('Pull image for deployment') {
                    steps {

                    withCredentials([usernamePassword(credentialsId: 'alidaoud-dockerhub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
                            sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
                            sh 'docker pull alidaoud/mongo-demo:latest'
                        }
                    }
                }

        stage('Deploy') {
            steps {
                sh 'minikube cache add alidaoud/mongo-demo:latest'
                sh 'minikube cache reload'
                //sh 'kubectl delete -f k8s/mongo-demo-deployment.yaml'
                sh 'kubectl apply -f dep'

            }
        }
    } // Stages
} // Pipeline
