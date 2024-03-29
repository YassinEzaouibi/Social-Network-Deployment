FROM openjdk:8-jdk-alpine
LABEL authors="yasso"

WORKDIR /app

COPY target/notification-service-0.0.1-SNAPSHOT.jar notification.jar
ENTRYPOINT ["java","-jar", "notification.jar"]