pipeline {
    agent any

    stages {

        stage('Test') {
            steps {
                sh '''
                    java -version
                    mvn -version
                    mvn test
                '''
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t shopcart-order-service:${BUILD_NUMBER} .'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                    docker stop shopcart-order-service-container || true
                    docker rm shopcart-order-service-container || true

                    docker run -d \
                      --name shopcart-order-service-container \
                      -p 8081:8080 \
                      shopcart-order-service:${BUILD_NUMBER}
                '''
            }
        }

        stage('Health Check') {
            steps {
                sh '''
                    sleep 10
                    curl -f http://localhost:8081/actuator/health
                '''
            }
        }
    }
}
