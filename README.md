Enforce schema validation --> https://docs.confluent.io/platform/current/schema-registry/schema-validation.html#sv-on-cs

Good blog post --> https://codersee.com/how-to-deploy-multiple-kafka-brokers-with-docker-compose/


## :computer: Requirements

The project was developed using `openjdk 11.0.18` and built with `Apache Maven 3.8.7`.

To check your version of Java and Maven, type the following commands; with the output for my configuration below.

```bash
## Check Java version
($)> java --version
openjdk 11.0.18 2023-01-17
OpenJDK Runtime Environment (build 11.0.18+10)
OpenJDK 64-Bit Server VM (build 11.0.18+10, mixed mode)

## Check Maven version
($)> mvn --version
Apache Maven 3.8.7 (b89d5959fcde851dcb1c8946a785a163f14e1e29)
Maven home: /opt/maven
Java version: 11.0.18, vendor: Oracle Corporation, runtime: /usr/lib/jvm/java-11-openjdk
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "6.1.12-arch1-1", arch: "amd64", family: "unix"
```

If you do not have these configs, or if you do not have/do not want to install Java and Maven; I also built a Docker image for this small Java application. Make sure to have [Docker installed](https://docs.docker.com/get-docker/). My Docker config is

```bash
## Check Docker version
($)> docker --version
Docker version 23.0.1, build a5ee5b1dfc
```

This image can be pulled from my [dockerhub repo](https://hub.docker.com/u/theodorecurtil).


## :building_construction: Build the project

Build the project using

```console
mvn clean compile assembly:single
```

You can run the producer locally using the java CLI

```console
java -Dkafka.server.ip=http://localhost:9092 -Dschema.registry.ip=http://localhost:8081 -jar target/kafka_producer-1.0-SNAPSHOT-jar-with-dependencies.jar
```

Alternatively, you can also run the application inside a Docker container running the command

```console
docker run --name my_producer --network <kafka-infra-network> -e KAFKASERVER=http://<kafka-server-container-name>:29092 -e SCHEMAREGISTRY=http://<schema-registry-container-name>:8081  kafka_sales_producer:latest
```