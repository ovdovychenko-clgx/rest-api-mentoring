pipeline {
           agent any
           stages {
                stage("Build") {
                      steps {
			script {
				if (${BuildTool} == "Maven") {
                            		sh 'Maven build finished'
				}
                    		if (${BuildTool} == "Gradle") {
                            		sh 'Gradle build finished'
				}
                    	}
                      }           
                }
           }
      }

