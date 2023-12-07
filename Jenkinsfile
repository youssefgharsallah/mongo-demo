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
         stage('Build') {
            steps {
                script {
                    sh 'mvn test'
                    sh 'mvn clean package -DskipTests'
                   // sh 'docker build -t alidaoud/mongo-demo .'
                }
            }
        }
    }
}
