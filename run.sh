#!/bin/bash

git pull
mvn clean package -Dmaven.test.skip=true

docker rm -f user
docker rmi -f user:test
docker build -t user:test .
docker run -d -p 6821:6821  --label aliyun.logs.catalina=stdout  --label aliyun.logs.access=/log/.*.log    --name user user:test java -Dspring.profiles.active=test -jar /app/app.jar

# --label aliyun.logs.target=huarui_user_index