Here’s the list of Kafka components:

1. Producer
2. Consumer
3. Partition
4. Broker
5. Topic
6. Consumer Group
7. Zookeeper (or Kafka Controller in KRaft mode)

1. **Producer** : Producer is the source of data who will publish the message or events. consumer  acts as a receiver or consumer of the messages or events. But they won't communicate directly from each other to process the message from producer to consumer there should be a middle man between them that's is what called as Kafka Server or Broker.
   
2. **Consumer** : Its acts as a receiver or consumer of message or events. Fetches records from topics and processes them. Each consumer belongs to a **consumer group**, where multiple consumers can divide the work of reading records.
   
3. **Broker**:  Kafka Broker is a server that stores and serves messages. it's role is to Handles all incoming requests for data writing and retrieval, Maintains data in **topics** and ensures fault tolerance by replicating data across multiple brokers.
    **Key Points**:
	- A Kafka cluster consists of one or more brokers.
	- Each broker is identified by a unique ID.
 4. **Topic** : It specifies the category of the message or the classification of the message. Listeners can then just response to the message that they belong to the topic they are listening on.
 
	**Role**:
	
	- Organizes data; producers write to a specific topic, and consumers read from it.
	- Topics can have one or more **partitions**, which are sub-divisions of the topic. 

	![[Chapter-2/Images/Image_2.png]]

5. Partion:
	A **partition** in Kafka is like a slice of a larger pie (the topic). It’s a smaller, manageable chunk of data within a topic. Each topic is divided into one or more partitions to help distribute and process data more efficiently.
	Think of it like this:
	- A **topic** is a big storage box.
	- A **partition** is like dividing that storage box into separate compartments.
	  
		Each message in a partition has a unique **offset**, which is like its position number in the partition. This helps consumers track which messages they’ve already read.
		
6. Offset: In Kafka, an **offset** is a unique identifier assigned to each message within a partition. It acts like a sequential number or a bookmark that helps track the position of a message in the partition.
   
   ### **Key Characteristics of an Offset**
	
	1. **Unique Within a Partition**:
	    - Offsets are unique only within a specific partition. Two different partitions can have the same offset for their messages.
	2. **Sequential Order**:
	    - Messages in a partition are written in the exact order they arrive, and each new message gets the next available offset.
	3. **Used by Consumers**:
	    - Consumers use offsets to keep track of the messages they’ve already read. For example:
	        - If a consumer has processed up to offset **5**, it knows the next message to read is at offset **6**.
	4. **Durable**:
	    - Kafka keeps a record of offsets for a configurable retention period. Consumers can use this to resume processing from a specific offset after a failure.
   ![[Chapter-2/Images/Image_3.png]]
	Suppose a topic has a partition with the following messages:
											
	- Offset 0: `{"order_id": 1, "item": "Laptop"}`
	    
	- Offset 1: `{"order_id": 2, "item": "Phone"}`
	    
	- Offset 2: `{"order_id": 3, "item": "Tablet"}`
	    
	- A consumer starts reading and processes:
	    
	    - Offset 0 first, then offset 1, and then offset 2.
			- If the consumer stops after processing offset 1, it can resume from offset 2 later.
			  
7. **Consumer Group:**
   
   A **Kafka Consumer Group** is a way to group multiple Kafka consumers together to share the workload of reading and processing messages from one or more topics. It enables scalability, fault tolerance, and parallel processing.
   - All consumers in a group work together to process data from the same topic(s).
   - Kafka ensures that each partition in a topic is processed by only one consumer in the group.
  -  Kafka automatically assigns partitions to consumers in the group.
  - Each consumer in the group processes one or more partitions, but a single partition cannot be processed by multiple consumers in the same group.
    
    
8. Zookeeper
   **Zookeeper** is a distributed coordination service that Kafka uses to manage metadata and handle tasks that ensure Kafka's cluster functionality. It plays a crucial role in older versions of Kafka (pre-2.8) but is being replaced by Kafka's **KRaft mode** in newer versions.
    
    
  Cluster:
   A **Kafka cluster** is a group of one or more Kafka brokers working together to provide high availability, fault tolerance, and scalability for message streaming. It forms the backbone of a Kafka system, managing data distribution, storage, and processing across its nodes.
   ![[Chapter-2/Images/Image_1.png]]
   
1. 