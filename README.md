Enforce schema validation --> https://docs.confluent.io/platform/current/schema-registry/schema-validation.html#sv-on-cs

Good blog post --> https://codersee.com/how-to-deploy-multiple-kafka-brokers-with-docker-compose/


## Requirements

The project was developed using `openjdk 11.0.18` and built with `Apache Maven 3.8.7`.

To check your version of java and Maven, type the following commands; with the output for my configuration below.

```console
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


## Build the project

Build the project using

```console
mvn clean compile assembly:single
```