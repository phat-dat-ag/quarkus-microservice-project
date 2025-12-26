ARG BUILDER_IMAGE=quay.io/quarkus/ubi-quarkus-graalvmce-builder-image:22.3-java17
FROM ${BUILDER_IMAGE} AS builder
USER root
RUN microdnf update -y && \
    microdnf install -y --setopt=install_weak_deps=0 git findutils && \
    microdnf clean all

USER quarkus
WORKDIR /work
COPY pom.xml mvnw /work/
COPY .mvn/ /work/.mvn/
# Run Maven to cache dependencies
RUN ./mvnw clean dependency:go-offline
RUN ./mvnw quarkus:go-offline

ENTRYPOINT [ "sh" ]
