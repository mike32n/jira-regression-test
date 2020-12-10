pipeline {
    agent any
    parameters {
            string(name: 'browserToRun', defaultValue: 'both', description: 'Browsers to run: Both, Chrome, Firefox')
            string(name: 'chrome', defaultValue: 'chrome', description: 'Chrome browser')
            string(name: 'firefox', defaultValue: 'firefox', description: 'Firefox browser')
            }
    stages {
        stage('Build') {
            steps {
                script {withCredentials([[$class: 'UsernamePasswordMultiBinding',
                    credentialsId: 'jira-user6-credentials',
                        passwordVariable: 'pass',
                        usernameVariable: 'user']]) {
                            // some block
                            echo 'Build phase: '
                            sh 'mvn clean'
                        }
                }

            }
        }
        stage('Test') {
            parallel {
                stage('run with chrome') {
                    when {
                        expression { params.browserToRun == 'both' || params.browserToRun == 'chrome' }
                    }
                    steps {
                        echo 'Test phase with chrome: '
                        sh "mvn test -Denv.USER=$user -Denv.PASS=$pass"
                    }
                    post {
                        always {
                            junit 'target/surefire-reports/*.xml'
                        }
                    }
                }
                stage('run with firefox') {
                    when {
                        expression { params.browserToRun == 'both' || params.browserToRun == 'firefox' }
                    }
                    steps {
                        echo 'Test phase with firefox: '
                        sh "mvn test"
                    }
                    post {
                        always {
                            junit 'target/surefire-reports/*.xml'
                        }
                    }
                }
            }
        }
    }
    post {
        always {
            echo 'Cleanup phase: '
            cleanWs()
        }
    }
}