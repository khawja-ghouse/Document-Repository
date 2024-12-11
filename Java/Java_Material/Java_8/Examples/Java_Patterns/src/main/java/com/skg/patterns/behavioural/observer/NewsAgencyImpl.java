package com.skg.patterns.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

public class NewsAgencyImpl implements NewsAgency{
    private final List<Channel> channels = new ArrayList<>();
    private String news;

    @Override
    public void registerChannel(Channel channel) {
        channels.add(channel);
    }

    @Override
    public void unregisterChannel(Channel channel) {
        channels.remove(channel);
    }

    @Override
    public void notifyChannels() {
        for (Channel channel : channels) {
            channel.update(news);
        }
    }

    public void setNews(String news) {
        this.news = news;
        notifyChannels();
    }
}
