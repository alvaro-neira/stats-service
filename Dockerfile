# Use a base image with Java installed (Eclipse Temurin is a popular choice)
FROM eclipse-temurin:21-jdk-alpine

# Copy your built jar file into the image
COPY target/stats-service-0.0.1-SNAPSHOT.jar app.jar

# Tell Docker to run this command when the container starts
ENTRYPOINT ["java", "-jar", "/app.jar"]