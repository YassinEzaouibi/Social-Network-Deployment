FROM openjdk:8-jdk-alpine
LABEL authors="yasso"

WORKDIR /app

COPY target/interaction-service-0.0.1-SNAPSHOT.jar interaction.jar
ENTRYPOINT ["java","-jar", "interaction.jar"]