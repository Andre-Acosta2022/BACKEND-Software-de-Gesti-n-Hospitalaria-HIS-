FROM openjdk:21-jdk-slim
WORKDIR /app
COPY empleados-service/target/empleados-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "app.jar"]
