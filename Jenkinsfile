pipeline {
    agent any

    tools {
        maven 'Maven-3-9-6'
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
    }
}
