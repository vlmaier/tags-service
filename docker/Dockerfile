FROM openjdk:17.0.1-jdk-slim
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} tags-service.jar
ENTRYPOINT ["java", "-jar", "tags-service.jar"]