#!/bin/sh
mvn clean install
docker build .
grep 'Successfully built' build.txt | awk '{print $3}'> container.txt
containerid=$(cat container.txt)
echo $containerid
docker run -p 8080:8080 -d $containerid
docker ps | grep $containerid > running.txt
grep $containerid running.txt | awk '{print $14}'