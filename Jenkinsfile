pipeline {
           agent any
           stages {
                stage("Build") {
                      steps {
			      script {
				if (params.buildTool == "Maven") {
                            		echo 'Maven build finished'
				}
                    		if (params.buildTool == "Gradle") {
                            		echo 'Gradle build finished'
				}
			      }
                      }           
                }
           }
      }

