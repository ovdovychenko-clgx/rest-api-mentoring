pipeline {
	agent any
	tools {
		maven 'Maven 3.3.9'
        jdk 'jdk8'
    }
    stages {
		stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
            stage("Build") {
                steps {
                    script {
            			if (params.buildTool == "Maven") {
            			    sh 'mvn -Dmaven.test.failure.ignore=true install'
                            echo 'Maven build finished'
            			}
                        if (params.buildTool == "Gradle") {
                            echo 'Gradle build finished'
                        }
            	    }
            	}
            	post {
                    success {
                        junit 'target/surefire-reports/**/*.xml'
                    }
                }
            }
        }
    }
}

