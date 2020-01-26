pipeline {
    agent any
    stages {
        stage("Code Checkout") {
            steps {
                git branch: "master",
                url: "https://github.com/jonathanPOA/simulador-investimento.git"
                credentialsId: 'jonathanPOA'
                                /* change credentialsId to your Jenkins credentialsId */
            }
        }
        stage("Build Docker Image") {
            steps {
                sh("docker build -t simulador-investimentos .")
            }
        }
        stage("Start Selenium Server") {
            steps {
                sh("docker run -d --network host -p 4444:4444 selenium/standalone-chrome")
            }
        }
        stage("Run Tests") {

            steps {
                sh("docker run --network host -v '$pwd:/usr/src/app/build/' simulador-investimentos gradle cucumber")
            }
        }
    }
}