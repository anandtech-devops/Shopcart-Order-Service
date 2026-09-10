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
    }
}
