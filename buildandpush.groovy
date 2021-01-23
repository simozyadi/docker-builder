pipeline {

	agent any
	
	stages {
		stage('Docker Build & Push'){
			steps{
				withCredentials('docker-credentials'){
				script{
				
					sh 'docker build -t lab/$BRANCH_NAME:$BUILD_NUMBER .'
					sh 'docker push lab/$BRANCH_NAME:$BUILD_NUMBER
				
					}
				}
			}
		}
	}
}