pipeline{
    agent any 
    
    enviornment{
        VERSION_NAME = 1.32.3
    }
    stages{

        stage ("compile"){
            steps{
                
            sh  ' javac Test.java '
            sh ' echo "${VERISON_NAME}"'
            }
        }
        stage ("run"){
            steps{

            sh  " java Test.java  "
            }
        }
    }

    post{ // after stages run hone ke baad ye chalega post  

        success{ 
               sh 'echo " Build Success"'
        }

        failure{
            sh 'echo "Build Failed"'
        }

        always{
            sh 'echo "This vro always runs " '
        }
    }
}