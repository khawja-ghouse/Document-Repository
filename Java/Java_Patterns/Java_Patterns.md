## What are Design Patterns?

A design pattern is a generic repeatable solution to a frequently occurring problem in software design that is used in software engineering. It isn’t a complete design that can be written in code right away. It is a description or model for problem-solving that may be applied in a variety of contexts.

## Types of Design Patterns in Java
Java design patterns are divided into three categories –
- creational
- structural, and
- behavioral design patterns.

1. **Creational Design Pattern**
	They deal with the process of object creation, trying to make it more flexible and efficient. It makes the system independent and how its objects are created, composed, and represented.
	 **Types of creational design pattern**
		1.1 Factory Method design pattern
		     Factory Method Design Pattern define an **interface for creating an object, but let subclass decide which class to instantiate**. Factory Method lets a class defer instantiation to subclass.
```java
// Interface representing a multimedia player
interface Player {
    void play();
}

// Concrete implementation of AudioPlayer
class AudioPlayer implements Player {
    @Override
    public void play() {
        System.out.println("Playing audio...");
    }
}

// Concrete implementation of VideoPlayer
class VideoPlayer implements Player {
    @Override
    public void play() {
        System.out.println("Playing video...");
    }
}

// Factory interface for creating players
interface PlayerFactory {
    Player createPlayer();
}

// Factory for creating AudioPlayer
class AudioPlayerFactory implements PlayerFactory {
    @Override
    public Player createPlayer() {
        return new AudioPlayer();
    }
}

// Factory for creating VideoPlayer
class VideoPlayerFactory implements PlayerFactory {
    @Override
    public Player createPlayer() {
        return new VideoPlayer();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        PlayerFactory audioFactory = new AudioPlayerFactory();
        Player audioPlayer = audioFactory.createPlayer();
        audioPlayer.play(); // Output: Playing audio...
        
        PlayerFactory videoFactory = new VideoPlayerFactory();
        Player videoPlayer = videoFactory.createPlayer();
        videoPlayer.play(); // Output: Playing video...
    }
}
```

Example 2:
```java

public interface Notification {
   void notifyUser();
}

SMSNotification.java
public class SMSNotification implements Notification {
	@Override
	public void notifyUser(){
	  System.out.println("Sending an SMS notification");
	}
}

EmailNotification.java
public class EmailNotification implements Notification {
	@Override
	public void notifyUser(){
	  System.out.println("Sending an email notification");
	}
}

PushNotification.java
public class PushNotification implements Notification {
     @Override
     public void notifyUser(){
	     System.out.println("Sending a Push Notification");
     }
}

public class NotificationFactory {

	public Notification createNotification(String channel)
	{
		if (channel == null || channel.isEmpty())
			return null;
		switch (channel) {
		case "SMS":
			return new SMSNotification();
		case "EMAIL":
			return new EmailNotification();
		case "PUSH":
			return new PushNotification();
		default:
			throw new IllegalArgumentException("Unknown channel "+channel);
		}
	}
}

public class NotificationService {
	public static void main(String[] args)
	{
		NotificationFactory notificationFactory = new NotificationFactory();
		Notification notification = notificationFactory.createNotification("SMS");
		notification.notifyUser();
	}
}

Output : Sending an SMS Notification.

```

Advantages of Factory Method Design Pattern in java

**Decoupling** 
**Extensibility** - its easy to introduce new product type with out changing the client code.
**Code Reusability** - The factory method can be re used in different parts of application where ever
its necessary.

Disadvantages 
**Increased Complexity:** It introduces additional classes and interfaces, adding another layer of abstraction that can make the code more complex to understand and maintain, especially for those who has no idea of the design patterns.

2. Abstract Factory Method:
	   
1. 