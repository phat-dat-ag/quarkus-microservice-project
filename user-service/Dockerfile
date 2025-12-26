FROM eclipse-temurin:17-jre-alpine

WORKDIR /work

COPY target/quarkus-app/quarkus-run.jar ./quarkus-run.jar

EXPOSE 8080

CMD ["java", "-jar", "./quarkus-run.jar"]
