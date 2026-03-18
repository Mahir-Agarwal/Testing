pipeline {
agent any

environment {
    VERSION_NAME = "1.32.3"   // Ye ek environment variable hai
}

stages {

    stage ("compile") {
        steps {
            sh 'javac Test.java'             // Java file compile karega
            sh 'echo "${VERSION_NAME}"'      // Version print karega
        }
    }

    stage ("run") {
        steps {
            sh 'java Test'                   // Compiled class run karega
        }
    }
}

post {   // Ye stages ke baad run hota hai

    success { 
        sh 'echo "Build Success"'            // Agar sab sahi hua
    }

    failure {
        sh 'echo "Build Failed"'             // Agar koi stage fail hua
    }

    always {
        sh 'echo "This always runs"'         // Har case me chalega
    }
}


}
