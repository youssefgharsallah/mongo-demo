pipeline {
    agent any

    tools {
        maven 'Maven3.9.6'
    }
//j
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
         stage('Push image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub', password variable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
                    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
                    sh 'docker push youssefbushman/mongo-demo:latest'
                }
            }
        }
    }
}
