package com.skg.patterns.creational.singleton;

public class ThreadExample extends Thread {

    public void run() {
        Singleton singleton = Singleton.getInstance();
        System.out.println("Child Thread " + Thread.currentThread().getName());
        System.out.println("Hash Code " + singleton.hashCode());
    }
}
