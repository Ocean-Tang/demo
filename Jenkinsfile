pipeline {

    agent any

    tools {
        maven 'Maven3'
    }

    stages {

        stage('拉取代码') {
            steps {
                checkout scm
            }
        }

        stage('构建jar包') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('打包Docker') {
            steps {
                sh 'docker build -t demo:${GIT_COMMIT} .'
            }
        }

        stage('部署') {
            steps {
                sh '''
                docker stop demo || true
                docker rm demo || true

                docker run -d \
                    --name demo \
                    -p 1010:1010 \
                    demo:${GIT_COMMIT}
                '''
            }
        }
    }
}