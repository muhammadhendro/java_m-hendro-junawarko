FROM adoptopenjdk/openjdk11:alpine

WORKDIR /app

# Copy application files
COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]