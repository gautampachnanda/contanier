# Kube Sample App

```
curl https://start.spring.io/starter.tgz -d dependencies=webflux,actuator | tar -xzvf -
```
Create Dockerfile

```
FROM openjdk:8-jdk-alpine AS builder
WORKDIR target/dependency
ARG APPJAR=target/*.jar
COPY ${APPJAR} app.jar
RUN jar -xf ./app.jar

FROM openjdk:8-jre-alpine
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY --from=builder ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=builder ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=builder ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.demo.DemoApplication"]
```

Build and tag

```
docker build . -t yourdockername/kube-starter-demo
docker push yourdockername/kube-starter-demo
```



```
kubectl create deployment kube-starter-demo --image=yourdockername/kube-starter-demo --dry-run -o=yaml > deployment.yaml
echo --- >> deployment.yaml
kubectl create service clusterip kube-starter-demo --tcp=8080:8080 --dry-run -o=yaml >> deployment.yaml
```

```
kubectl apply -f deployment.yaml
```

```
deployment.apps/demo created
service/demo created
````

```
kubectl get all
```

```
kubectl port-forward svc/kube-starter-demo 1235:8080
```