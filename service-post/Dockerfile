FROM openjdk:8-jdk-alpine
LABEL authors="yasso"

WORKDIR /app

COPY target/service-post-0.0.1-SNAPSHOT.jar post.jar
ENTRYPOINT ["java","-jar", "post.jar"]