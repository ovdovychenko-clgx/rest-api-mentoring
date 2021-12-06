pipeline {
           agent any
           stages {
                stage("Build") {
                      steps {
			script {
                    		if (params.BuildTool == "Maven") {
                        		stage ('Build Stage') {
                            		sh 'Maven build finished'
                        		}}
                    		if (params.BuildTool == "Gradle") {
                       		stage ('Build Stage') {
                            		sh 'Gradle build finished'
                        		}}
                    	}
                      }           
                }
           }
      }

