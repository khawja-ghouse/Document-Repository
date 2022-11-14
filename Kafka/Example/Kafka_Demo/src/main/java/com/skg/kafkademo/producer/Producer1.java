package com.skg.kafkademo.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

public class Producer1 {

	public static void main(String[] args) {

		Properties properties = new Properties();
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		// Creating producer
		KafkaProducer<String, String> firstProducer = new KafkaProducer<String, String>(properties);

		// Producer Record
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("my_first",
				"Hello Kafka user...Again");

		// producer without handling error or unsuccessful produced data
		// firstProducer.send(record);

		firstProducer.send(record, new Callback() {
			public void onCompletion(RecordMetadata recordMetadata, Exception e) {
				if (e == null) {
					System.out.println("Successfully recieved the details as: \n" + "Topic:" + recordMetadata.topic()
							+ "\n" + "artition:" + recordMetadata.partition() + "\n"
							+ "offset” + recordietadata.offset() + “\n" + "Timestamp" + recordMetadata.timestamp());

				} else {

				}

			}
		});
		firstProducer.flush();
		firstProducer.close();
	}
}
// 
