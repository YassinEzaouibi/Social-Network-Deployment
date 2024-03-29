FROM openjdk:8-jdk-alpine
LABEL authors="yasso"

WORKDIR /app

COPY target/media-service-0.0.1-SNAPSHOT.jar media.jar
ENTRYPOINT ["java","-jar", "media.jar"]