FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /workspace
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src src
RUN mvn package

# Stage 2: Create a lightweight image with only the JAR file
FROM openjdk:17.0.2-jdk-slim-bullseye

RUN addgroup backend; adduser  --ingroup backend --disabled-password spring
USER spring

WORKDIR /workspace
COPY --from=build /workspace/target/app-0.0.1-SNAPSHOT.jar /workspace/app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]