FROM openjdk:8-jdk-alpine
LABEL authors="yasso"

WORKDIR /app

COPY target/user-service-0.0.1-SNAPSHOT.jar user.jar
ENTRYPOINT ["java","-jar", "user.jar"]