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
                    		if (false) {
                       		stage ('Stage 2') {
                            		sh 'echo Stage 2'
                        		}}
                    	}
                      }           
                }
           }
      }

