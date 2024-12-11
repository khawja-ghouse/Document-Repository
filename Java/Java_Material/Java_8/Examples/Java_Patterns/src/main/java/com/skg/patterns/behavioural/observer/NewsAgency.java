package com.skg.patterns.behavioural.observer;

public interface NewsAgency {
    void registerChannel(Channel channel);
    void unregisterChannel(Channel channel);
    void notifyChannels();

}
