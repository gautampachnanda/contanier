
#!/bin/sh
dockerrepo=$1
dirname=$2
appname=$3

if [ "$#" -eq 3 ]
    then
    	echo ""
    	echo "-------------------------------------------------"
        echo "Docker repo name : $1"
		echo "Dirname : $2"
		echo "App name: $3"
		echo "-------------------------------------------------"
 else
    echo "Arguments are not equals to 3"
    echo "Useage: sh init.sh docketreponame dirname appname"
    exit 1
 fi

mkdir $dirname

cd $dirname && curl https://start.spring.io/starter.tgz -d dependencies=webflux,actuator | tar -xzvf - && cd ..

ls -lah "$dirname"

echo 'Creating docker file'

touch $dirname/Dockerfile

echo 'FROM openjdk:8-jdk-alpine AS builder' > $dirname/Dockerfile
echo 'WORKDIR target/dependency' >> $dirname/Dockerfile
echo 'ARG APPJAR=target/*.jar' >> $dirname/Dockerfile
echo 'COPY ${APPJAR} app.jar' >> $dirname/Dockerfile
echo 'RUN jar -xf ./app.jar' >> $dirname/Dockerfile

echo 'FROM openjdk:8-jre-alpine' >> $dirname/Dockerfile
echo 'VOLUME /tmp' >> $dirname/Dockerfile
echo 'ARG DEPENDENCY=target/dependency' >> $dirname/Dockerfile
echo 'COPY --from=builder ${DEPENDENCY}/BOOT-INF/lib /app/lib' >> $dirname/Dockerfile
echo 'COPY --from=builder ${DEPENDENCY}/META-INF /app/META-INF' >> $dirname/Dockerfile
echo 'COPY --from=builder ${DEPENDENCY}/BOOT-INF/classes /app' >> $dirname/Dockerfile
echo 'ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.demo.DemoApplication"]' >> $dirname/Dockerfile

cd $dirname && mvn install && docker build . -t $dockerrepo/$appname && cd ..

docker push $dockerrepo/$appname

kubectl create deployment $appname --image=$dockerrepo/$appname --dry-run -o=yaml > $dirname/deployment.yaml
echo --- >> $dirname/deployment.yaml
cat $dirname/deployment.yaml
kubectl create service clusterip $appname --tcp=8080:8080 --dry-run -o=yaml >> $dirname/deployment.yaml

kubectl apply -f $dirname/deployment.yaml
sleep 10
kubectl get all | grep $appname
echo 'run command  for port forwarding'
echo 'kubectl port-forward svc/$appname  1235:8080'
