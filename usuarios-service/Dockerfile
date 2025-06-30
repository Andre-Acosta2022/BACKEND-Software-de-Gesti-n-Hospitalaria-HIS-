FROM openjdk:21-jdk-slim
WORKDIR /app
COPY /target/usuarios-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8015
ENTRYPOINT ["java", "-jar", "app.jar"]
