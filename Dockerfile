# Этап 1: сборка (JDK)
FROM openjdk:17-jdk-slim AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN apt-get update && apt-get install -y maven && mvn clean package -DskipTests

# Этап 2: запуск (JRE)
FROM openjdk:17-jre-slim
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]