package com.skg.patterns.behavioural.observer;

public class NewsChannel implements  Channel{
    private final String name;

    public NewsChannel(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " received news: " + news);
    }
}
