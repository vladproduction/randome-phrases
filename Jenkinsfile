pipeline {
    agent any

    stages {

        stage('Stage#1: List Files Before Checkout') {
            steps {
                script {
                    bat 'dir'
                }
            }
        }

        stage('Stage#2: Checkout') {
            steps {
                script {
                    // Checkout the repository
                    checkout([$class: 'GitSCM',
                        branches: [[name: '*/main']],
                        userRemoteConfigs: [[url: 'https://github.com/vladproduction/randome-phrases']]
                    ])
                }
            }
        }

        stage('Stage#3: List Files After Checkout') {
            steps {
                script {
                   bat 'dir'
                }
            }
        }

    }
}

