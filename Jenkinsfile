pipeline {
           agent any
           stages {
                stage("Maven Build") {
                      when {
                          expression { params.BuildTool == "Maven" }
                      }
                      steps {
                          echo 'Maven build end'
                      }           
                }
                      
                stage("Gradle Build") {
                      when {
                          expression { params.BuildTool == "Gradle" }
                      }
                      steps {
                          echo 'Gradle build end'
                      }           
                }
           }
      }

