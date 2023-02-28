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


## :building_construction: Build the Project

### Clone the Repository

The first step is to clone this repository. `cd` into the folder where you want to host this project's repo and type the command

```console
## Clone repo
git clone git@github.com:theodorecurtil/kafka_sales_producer.git

## cd into the repo
cd ./kafka_sales_producer
```

If you want to play around with the Kafka producer, you can do so and build the application's jar-file using the following command within the `./kafka_sales_producer` folder.

```console
mvn clean compile assembly:single
```

:whale: You can also use the provided [Dockerfile](https://github.com/theodorecurtil/kafka_sales_producer/blob/main/Dockerfile) to build your own Docker image running your producer. To build your local image, run the following command from within the `./kafka_sales_producer` folder.

```console
docker build -t <image-name> .
```

## :factory: The Infrastructure

This repo only contains the Java application that publishes messages to an existing Kafka cluster. This means that this code won't run except it can pusblish messages to an existing Kafka cluster. In order to get this application to run, we need to start a Kafka cluster and related services...

:tada: The good thing is that this was the subject of my previous [blog post](https://acosom.com/)! To get a running local Kafka infrastructure is easy: simply refer to my [github repo](https://github.com/theodorecurtil/kafka_101) that accompanies the blog post.

To get the cluster up and running do the following

```console
## Clone repo
git clone git@github.com:theodorecurtil/kafka_101.git

## Docker compose up
cd ./kafka_101 && docker-compose up -d
```

You should see 4 services running on the Docker network `kafka_101_default`:

1. control-center
2. schema-registry
3. broker
4. zookeeper

Now that the infrastructure is running, we can start the Kafka producer!

## :running: Run the Application

One can run the application directly in the CLI using the `java` command, or in a Docker container (which I recommend as a good practice).

### In the CLI

You can run the producer locally using the java CLI. The `App.java` main method takes some command line arguments for the adress of the Kafka server, and of the schema registry. Because yes, in this repo we are also going to play around with [Confluent's schema registry](https://docs.confluent.io/platform/current/schema-registry/index.html#sr-overview). For a video intro about the schema registry, and why you should use the schema registry in th first place; refer to [this video](https://developer.confluent.io/learn-kafka/schema-registry/key-concepts/).

```console
java -Dkafka.server.ip=http://localhost:9092 -Dschema.registry.ip=http://localhost:8081 -jar target/kafka_producer-1.0-SNAPSHOT-jar-with-dependencies.jar
```

Alternatively, you can also run the application inside a Docker container running the command

```console
docker run --name my_producer --network <kafka-infra-network> -e KAFKASERVER=http://<kafka-server-container-name>:29092 -e SCHEMAREGISTRY=http://<schema-registry-container-name>:8081  kafka_sales_producer:latest
```