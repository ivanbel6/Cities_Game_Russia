pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
            
                git 'https://github.com/ivanbel6/Cities_Game_Russia.git'
            }
        }
        stage('Build') {
            steps {
                // Выполняем сборку
                echo 'Building project...'
                bat 'echo Building complete!'
            }
        }
        stage('Test') {
            steps {
                // Запускаем тесты
                echo 'Running tests...'
                bat 'echo Tests passed!'
            }
        }
        stage('Deploy') {
            steps {
                // Этап деплоя
                echo 'Deploying application...'
            }
        }
    }
}
