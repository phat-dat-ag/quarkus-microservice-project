FROM eclipse-temurin:17-jdk-alpine
#COPY target/order-service-1.0.0-SNAPSHOT.jar app.jar
COPY target/*-runner.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
