package com.skg.patterns.behavioural.mediator;

public class Client {
    public static void main(String[] args) {
        ChatMediator chatRoom = new ChatRoom();

        User user1 = new ChatUser(chatRoom, "Alice");
        User user2 = new ChatUser(chatRoom, "Bob");
        User user3 = new ChatUser(chatRoom, "Charlie");
        User user4 = new ChatUser(chatRoom, "Diana");

        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);
        chatRoom.addUser(user4);

        user1.sendMessage("Hello, everyone!");
//        user3.sendMessage("Hi Alice!");
    }
}
