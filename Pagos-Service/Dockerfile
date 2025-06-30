FROM openjdk:21-jdk-slim
WORKDIR /app
COPY Pagos-Service/target/Pagos-Service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8087
ENTRYPOINT ["java", "-jar", "app.jar"]
