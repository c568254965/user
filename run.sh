#!/bin/bash

git pull
mvn clean package -Dmaven.test.skip=true

docker rm -f user
docker rmi -f user:test
docker build -t user:test .
docker run -d -p 6821:6821 --name user user:test java -Dspring.profiles.active=test -jar /app/app.jar


# docker run -d -p 6821:6821 -v /code/huarui_res/user/log:/log  --label aliyun.logs.catalina=stdout  --label aliyun.logs.access=/code/huarui_res/user/log/.*.log    --name user user:test java -Dspring.profiles.active=test -jar /app/app.jar > user.log

# --label aliyun.logs.target=huarui_user_index