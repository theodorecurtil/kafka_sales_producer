package com.acosom;

import java.util.List;
import java.util.Arrays;
import java.util.Random;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import java.lang.IllegalArgumentException;

public class App 
{
    public static void main( String[] args )
    {
        String kafkaServerIP = System.getProperty("kafka.server.ip");
        String schemaRegistryIP = System.getProperty("schema.registry.ip");

        if (kafkaServerIP == null || schemaRegistryIP == null || kafkaServerIP.isEmpty() || schemaRegistryIP.isEmpty()) {
            throw new IllegalArgumentException("You have to set value for the Kafka server IP and the schema registry IP. With the Docker image, use env variables KAFKASERVER and SCHEMAREGISTRY; if running with the CLI use CLI arguments -Dkafka.server.ip=<kafka-server-ip:port> and -Dschema.registry.ip=<schema-registry-ip:port>");
        };

        // KafkaProducer
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServerIP);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        properties.put("schema.registry.url", schemaRegistryIP);

        KafkaProducer<String, StoreSale> producer = new KafkaProducer<>(properties);
        List<String> store_list = Arrays.asList("ABC", "DEF", "GHI");
        Random rand = new Random();
        
        while (true) {
            String store_id = store_list.get(rand.nextInt(store_list.size()));
            int sale_amount = ThreadLocalRandom.current().nextInt(100, 1000 + 1);

            StoreSale mySale = generateStoreSale(store_id, sale_amount);
            ProducerRecord<String, StoreSale> myRecord = new ProducerRecord<String,StoreSale>("SALES", mySale.getStoreId(), mySale);

            try {
                producer.send(myRecord);
                producer.flush(); 
                Thread.sleep(1000);
              } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                producer.close();
              }
        }
    }

    public static StoreSale generateStoreSale(String store_id, Integer sale_amount){
        Long sale_ts = System.currentTimeMillis();
        return new StoreSale(store_id, sale_amount, sale_ts);
    }
}
