FROM openjdk:8-jdk-alpine
LABEL authors="yasso"

WORKDIR /app

COPY target/feeds-service-0.0.1-SNAPSHOT.jar feeds.jar
ENTRYPOINT ["java","-jar", "feeds.jar"]