package com.skg.patterns.behavioural.observer;

public class Client {
    public static void main(String[] args) {
        NewsAgencyImpl newsAgency = new NewsAgencyImpl();

        Channel channel1 = new NewsChannel("Channel One ->");
        Channel channel2 = new NewsChannel("Channel Two ->");
        Channel channel3 = new NewsChannel("Channel Three ->");

        // Registering channels to the news agency
        newsAgency.registerChannel(channel1);
        newsAgency.registerChannel(channel2);
        newsAgency.registerChannel(channel3);

        // Updating news
        newsAgency.setNews("Breaking News: Observer Pattern Simplified!");

        newsAgency.setNews("Weather Update: Sunny all day!");
    }
}
