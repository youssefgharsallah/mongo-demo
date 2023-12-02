pipeline {
   agent any

       tools {
           maven 'Maven-3-9-6'
       }

    stages {
        stage('Build and Run') {
            steps {
                script {
                    git 'https://github.com/alidaoud7/mongo-demo.git'
                    sh 'mvn clean package -DskipTests'
                    // sh 'docker build -t alidaoud/mongo-demo /home/jenkins/proj'
                   sh 'docker build -t app .'
                }
            }
        }


    }
}