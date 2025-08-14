# docker build -t tickets-sales:latest .

# Stage 1: Build the Spring Boot application
FROM maven:3.9-amazoncorretto-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Create the final image
FROM amazoncorretto:17-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 4000
ENTRYPOINT ["java", "-jar", "app.jar"]