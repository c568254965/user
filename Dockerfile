FROM codenvy/jdk8_maven3_tomcat8
ADD target/user-1.0-SNAPSHOT.jar /app/app.jar
CMD ["chmod","777","log/"]
CMD ["java","-jar","-Dspring.profiles.active=test","/app/app.jar"]
