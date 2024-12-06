package com.skg.patterns.creational.singleton;

public class SingletonClient {
    public static void main(String[] args) {

        ThreadExample T1 = new ThreadExample();
        ThreadExample T2 = new ThreadExample();
        ThreadExample T3 = new ThreadExample();
        ThreadExample T4 = new ThreadExample();

        T1.start();
        T2.start();
        T3.start();
        T4.start();

    }
}
