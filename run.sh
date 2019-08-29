#!/bin/bash

git pull
mvn clean package -Dmaven.test.skip=true

docker rm -f huarui_user
docker rmi -f c568254965/huarui_user:v1.0
docker build -t c568254965/huarui_user:v1.0 .
# docker run -d -p 6821:6821 --privileged=true  --name  user user:test java -Dspring.profiles.active=test -jar /app/app.jar

 docker run -d -p 6821:6821  -v /opt/my-code/user/log:/log  --label aliyun.logs.catalina=stdout  --label aliyun.logs.access=/log/*.log    --name huarui_user c568254965/huarui_user:v1.0  java -Dspring.profiles.active=test -jar /app/app.jar > user.log

# --label aliyun.logs.target=huarui_user_index
