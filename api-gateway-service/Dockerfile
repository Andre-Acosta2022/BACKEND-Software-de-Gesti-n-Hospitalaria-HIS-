FROM openjdk:21-jdk-slim
WORKDIR /app
COPY api-gateway-service/target/api-gateway-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8014
ENTRYPOINT ["java", "-jar", "app.jar"]
