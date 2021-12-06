pipeline {
           agent any
           stages {
                stage("Build") {
                      steps {
			      script {
				if (params.BuildTool == "Maven") {
                            		echo 'Maven build finished'
				}
                    		if (params.BuildTool == "Gradle") {
                            		echo 'Gradle build finished'
				}
			      }
                      }           
                }
           }
      }

