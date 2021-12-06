pipeline {
           agent any
           stages {
                when {
                          expression { params.BuildTool == "Maven" }
                      }
                      
                stage("Maven Build") {
                      steps {
                          echo 'Maven build end'
                      }           
                }
                when {
                          expression { params.BuildTool == "Gradle" }
                      }
                stage("Gradle Build") {
                      steps {
                          echo 'Gradle build end'
                      }           
                }
           }
      }

