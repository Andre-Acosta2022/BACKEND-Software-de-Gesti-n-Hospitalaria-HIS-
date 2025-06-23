FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/Notificaciones-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8088
ENTRYPOINT ["java", "-jar", "app.jar"]
