FROM eclipse-temurin:17-jre
WORKDIR /deployments

COPY target/quarkus-app/lib/ lib/
COPY target/quarkus-app/app/ app/
COPY target/quarkus-app/quarkus/ quarkus/
COPY target/quarkus-app/quarkus-run.jar .

CMD ["java","-jar","quarkus-run.jar"]