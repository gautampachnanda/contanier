#!/bin/sh
containerName=''
containerId=''
function initDockerFile(){
	echo 'Copying dockerfiles from template'
	cp ../../dockerfiles/j8bootableJar/mvn/Dockerfile .
}
function buildMvn(){
	echo 'Building using maven'
	mvn clean install > /dev/null
	docker build . > build.txt
	echo 'Project build complete'
}
function buildGradle(){
	echo 'Building using gradle'
	gradle clean build > /dev/null
	docker build . > build.txt
	echo 'Project build complete'
}
function findContainerId(){
	containerId=$(cat container.txt)
	echo "Found container id: $containerId"
}
function findContainerName(){
	echo "Checking container name for $containerId"
	docker ps | grep $containerId
	echo "Finding name for $containerId"
	containerName=$(docker ps | grep $containerId | awk '{print $12}')
	if [ "$containerName" != "" ]; then
		echo "Found container name: $containerName"
	fi
}
function info(){
	findContainerId
	findContainerName
}
function status(){
	info
	curl -I --http2 http://127.0.0.1:8080/actuator/health
}
function stopContainer(){
	status
	echo "Stopping container $containerName"
	if [ "$containerName" != "" ]; then
		docker stop $containerName
		echo "Stopped container $containerName"
	else
		echo "No running container found for id:$containerId  name:$containerName"
	fi
}
function dockerRun(){
	findContainerId
	docker run -p 8080:8080 -d $containerId
	docker ps | grep $containerId > running.txt
	sleep 10
	status
}