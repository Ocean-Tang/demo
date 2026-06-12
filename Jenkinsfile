pipeline {

    agent any

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
                sh 'docker build -t demo:${BUILD_NUMBER} .'
            }
        }

        stage('部署') {
            steps {
                sh '''
                docker stop demo || true
                docker rm demo || true

                docker run -d \
                    --name demo \
                    -p 8080:8080 \
                    demo:${GIT_COMMIT}
                '''
            }
        }
    }
}