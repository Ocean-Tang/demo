pipeline {

    agent any

    stages {

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
                    -p 8080:8080 \
                    demo:${GIT_COMMIT}
                '''
            }
        }
    }
}