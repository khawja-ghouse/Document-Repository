package com.skg.patterns.creational.singleton;

public class Singleton {

    // Volatile keyword ensures changes to this variable are visible across threads
    private static volatile Singleton instance;

    // Private constructor to prevent instantiation from other classes
    private Singleton() {
        // Initialization logic if required
    }

    // Public method to provide the Singleton instance
    public static Singleton getInstance() {
        if (instance == null) { // First check (without locking)
            synchronized (Singleton.class) { // Synchronized block
                if (instance == null) { // Second check (with locking)
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // Example method to demonstrate functionality
    public void showMessage() {
        System.out.println("Thread-Safe Singleton Instance: Hello, Singleton!");
    }
}
