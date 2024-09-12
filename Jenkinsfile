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
                      bat 'docker build -t vladbogdadocker/phrases:latest .'
                  }
             }
        }

        stage('Stage#7: Push Docker Image to Docker Hub') {
             steps {
                  script {
                       // Login to Docker Hub
                       //bat 'echo "%DOCKER_PASSWORD%" | docker login -u "%DOCKER_USERNAME%" --password-stdin'
                       // Push the latest image
                       bat 'docker push vladbogdadocker/phrases:latest'
                  }
             }
        }
    }

//     post {
//             success {
//                 // Notify the user of a successful build and image push
//                 script {
//                     mail to: 'vproductionsd@gmail.com',
//                          subject: "Jenkins Build Successful: ${currentBuild.fullDisplayName}",
//                          body: "The Docker image was successfully built and pushed to Docker Hub."
//                 }
//             }
//
//             failure {
//                 // Notify the user of a failed build
//                 script {
//                     mail to: 'vproductionsd@gmail.com',
//                          subject: "Jenkins Build Failed: ${currentBuild.fullDisplayName}",
//                          body: "The Jenkins build has failed. Please check the console output."
//                 }
//             }
//     }


}

