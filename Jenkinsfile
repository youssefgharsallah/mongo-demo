pipeline {
    agent any

    tools {
        maven 'Maven3.9.6'
    }
//hh
    stages {
        stage("checkout") {
            steps {
                 script {
                    git 'https://github.com/youssefgharsallah/mongo-demo.git'
                }
            }
        }
         stage('SonarQube') {
            steps {
                script {
                    withSonarQubeEnv('server-sonar') {
                        sh 'mvn sonar:sonar'
                    }
                }
            }
        }
         stage('Test and Build') {
            steps {
                script {
                    sh 'mvn test'
                    sh 'mvn clean package -DskipTests'
                    sh 'docker build -t youssefbushman/mongo-demo .'
                }
            }
        }
         stage('Push image to Dockerhub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
                    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
                    sh 'docker push youssefbushman/mongo-demo:latest'
                }
            }
        }
           stage('Pull image from dockerhub') {
                    steps {

                withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
                            sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
                            sh 'docker pull youssefbushman/mongo-demo:latest'
                        }
                    }
                }
         stage('Deploy') {
            steps {
                sh 'minikube cache add youssefbushman/mongo-demo:latest'
                sh 'minikube cache reload'
                sh 'kubectl apply -f dep/db-dep.yaml'
                sh 'kubectl apply -f dep/app-dep.yaml'
                sh 'kubectl apply -f dep/mongo-demo-db-config.yaml'
            }
        }
    }
}
