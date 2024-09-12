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

        stage('Stage#2: clean install') {
                    steps {
                        script {
                            bat './mvnw.cmd clean install'
                        }
                    }
                }

        stage('Stage#3: package') {
            steps {
                script {
                    bat './mvnw.cmd package'
                }
            }
        }



        stage('Stage#4: List Files After Checkout') {
            steps {
                script {
                   bat 'dir'
                }
            }
        }

    }
}

