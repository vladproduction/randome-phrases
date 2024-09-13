pipeline {
    agent any
    stages {
        stage('Stage#1: List Files Before package') {
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

        stage('Stage#4: List Files After package') {
            steps {
                script {
                   bat 'dir'
                }
            }
        }

        stage('Stage#5: Capture') {
             steps {
                 archiveArtifacts '**/target/*.jar'
                 jacoco()
                 junit '**/target/surefire-reports/TEST*.xml'
             }
        }

        stage('Stage#6: Build Docker Image') {
             steps {
                  script {
                      // we have a Dockerfile in the root of repository
                      bat 'docker build -t vladbogdadocker/phrases:%BUILD_NUMBER% .'
                  }
             }
        }

        stage('Stage#7: Push Docker Image to Docker Hub') {
             steps {
                  script {
                       // Login to Docker Hub
                       //bat 'echo "%DOCKER_PASSWORD%" | docker login -u "%DOCKER_USERNAME%" --password-stdin'
                       // Push the latest image
                       bat 'docker push vladbogdadocker/phrases:%BUILD_NUMBER%'
                  }
             }
        }

        stage('Stage#8: Push Image to Docker Hub as latest') {
             steps {
                 script {
                       bat 'docker tag vladbogdadocker/phrases:%BUILD_NUMBER% vladbogdadocker/phrases:latest'
                  }
                 script {
                       bat 'docker push vladbogdadocker/phrases:latest'
                  }
             }
        }

    }

    //post email imitation:
    post {
            always {
                script {
                    emailext(
                        body: "${env.BUILD_URL}\n${currentBuild.absoluteUrl}",
                        to: 'always@foo.bar',
                        recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'CulpritsRecipientProvider']],
                        subject: "${currentBuild.currentResult}: Job ${env.JOB_NAME} [${env.BUILD_NUMBER}]"
                    )
                }
            }
        }



}

