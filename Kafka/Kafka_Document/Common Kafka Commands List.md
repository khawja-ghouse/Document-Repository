1. Start the  Kafka Server With Kraft   
   >.\kafka-server-start.bat ..\..\config\kraft\server.properties
   
2. Create a Topic
   >bin/kafka-topics.bat --bootstrap-server localhost:9092 --create --topic NewTopic --partitions 3 --replication-factor 1
   
3. Open Producer CMD
   >bin/kafka-console-producer.bat --broker-list localhost:9092 --topic NewTopic
4. Open Consumer CMD
   > bin/kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic NewTopic --from-beginning
5. List all the Topics creates
   >windows>kafka-topics.bat --bootstrap-server localhost:9092 --list
6. Describe Topics
   >bin/kafka-topics --bootstrap-server localhost:9092 --describe --topic NewTopic1

   
   
   