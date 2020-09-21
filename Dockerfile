FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY target/indiumsoftware.jar /app/app.jar
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/app.jar"]