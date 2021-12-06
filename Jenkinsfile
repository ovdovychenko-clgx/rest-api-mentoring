pipeline {
           agent any
           stages {
                stage("Build") {
                      steps {
				when (params.BuildTool == "Maven") {
                            		echo 'Maven build finished'
				}
                    		when (params.BuildTool == "Gradle") {
                            		echo 'Gradle build finished'
				}
                      }           
                }
           }
      }

