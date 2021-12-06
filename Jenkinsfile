pipeline {
           agent any
           stages {
                stage("Build") {
                      steps {
			script {
                    		if (params.BuildTool == "Maven") {
                            		sh 'Maven build finished'
                    		if (params.BuildTool == "Gradle") {
                            		sh 'Gradle build finished'
                    	}
                      }           
                }
           }
      }

