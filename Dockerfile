#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build

WORKDIR /app

COPY src ./src
COPY pom.xml .

RUN mvn clean compile assembly:single

#
# Package stage
#
FROM openjdk:11-jre-slim
WORKDIR /app

# ENV KAFKASERVER=http://broker:29092
# ENV SCHEMAREGISTRY=http://schema-registry:8081

COPY --from=build /app/target/kafka_producer-1.0-SNAPSHOT-jar-with-dependencies.jar .

ENTRYPOINT java -Dkafka.server.ip=$KAFKASERVER -Dschema.registry.ip=$SCHEMAREGISTRY -jar kafka_producer-1.0-SNAPSHOT-jar-with-dependencies.jar