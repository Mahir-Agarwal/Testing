pipeline{
    agent any 
    stages{

        stage ("compile"){
            steps{
                
            sh  ' javac Test.java '
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