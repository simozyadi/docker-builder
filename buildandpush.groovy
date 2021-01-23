pipeline {

	agent any
	
	stages {
		stage('Docker Build & Push'){
			steps{
				script {
                    withCredentials([usernamePassword(credentialsId: 'docker-credentials', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                    sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
					sh 'docker build -t nimrodops/$BRANCH_NAME:$BUILD_NUMBER .'
					sh 'docker push nimrodops/$BRANCH_NAME:$BUILD_NUMBER'
				
					}
				}
			}
		}
	}
}