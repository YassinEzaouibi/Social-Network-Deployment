FROM openjdk:8-jdk-alpine
LABEL authors="yasso"

WORKDIR /app

COPY target/Friend-service-0.0.1-SNAPSHOT.jar friends.jar
ENTRYPOINT ["java","-jar", "friends.jar"]