# Spring Kafka Consumer/Producer Service


This microservice subscribes to Kafka topics and publishes JSON/String message to kafka topics. 

How to run this service:
1. Start Zookeeper
```shell
bin/zookeeper-server-start.sh config/zookeeper.properties
```
2. Start Kafka Server
```shell
bin/kafka-server-start.sh config/server.properties
```
3. Create Kafka Topic
```shell
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic Kafka_Example
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic Kafka_Example_json
```
4. Publish to the Kafka Topic via Console
```shell
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic Kafka_Example
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic Kafka_Example_json
```
5. Consume JSON/String messages from the kafka topic via Console
```shell
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic Kafka_Example --from-beginning
\bin\windows\kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic NewTopic --from-beginning
```