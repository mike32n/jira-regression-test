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
                echo 'Build phase: '
                sh 'mvn clean'
            }
        }
        stage('Test') {
            parallel {
                stage('run with chrome') {
                    when {
                        expression { params.browserToRun == 'both' || params.browserToRun == 'chrome' }
                    }
                    steps {
                        script {withCredentials([usernamePassword(
                            credentialsId: 'jira2-admin',
                            passwordVariable: 'pass',
                            usernameVariable: 'user')]) {
                                echo 'Test phase with chrome: '
                                echo user
                                sh "mvn test -X -DUSER=$user -DPASS=$pass"
                            }
                        }
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
                        script {withCredentials([usernamePassword(
                            credentialsId: 'jira2-admin',
                            passwordVariable: 'pass',
                            usernameVariable: 'user')]) {
                                echo 'Test phase with firefox: '
                                echo pass
                                sh "mvn test -X -DUSER=$user -DPASS=$pass"
                            }
                        }
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