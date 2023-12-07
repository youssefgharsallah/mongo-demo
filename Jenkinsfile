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
                    sh 'docker build -t myapp .'
                }
            }
        }
    }
}
