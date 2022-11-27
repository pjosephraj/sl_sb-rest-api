pipeline {
    agent any
    tools {
        maven "M3"

    }
    stages {
        stage('Compile and Clean') {
            steps {
                // Run Maven on a Unix agent.
                sh "mvn clean compile"
            }
        }
        stage('deploy') {

            steps {
                sh "mvn package"
            }
        }
        stage('Build Docker image'){

            steps {
                echo "Hello Java Express"
                sh 'ls'
                sh 'docker build -t  pjosephraj/spring-aws-jenkin:${BUILD_NUMBER} .'
            }
        }
        stage('Docker Login'){

            steps {
                 withCredentials([string(credentialsId: 'DockerId', variable: 'Dockerpwd')]) {
                    sh "docker login -u pjosephraj -p ${Dockerpwd}"
                }
            }
        }
        stage('Docker Push'){
            steps {
                sh 'docker push pjosephraj/spring-aws-jenkin:${BUILD_NUMBER}'
            }
        }
        stage('Docker deploy'){
            steps {

                sh 'docker run -itd -p  9090:9090 pjosephraj/spring-aws-jenkin:${BUILD_NUMBER}'
            }
        }
        stage('Archiving') {
            steps {
                 archiveArtifacts '**/target/*.jar'
            }
        }
    }
}