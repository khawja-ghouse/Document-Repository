package com.skg.patterns.creational.builder;

// The Product
public class Computer {
    private String processor;
    private int memory;
    private int storage;
    private String graphicsCard;

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "processor='" + processor + '\'' +
                ", memory=" + memory +
                ", storage=" + storage +
                ", graphicsCard='" + graphicsCard + '\'' +
                '}';
    }
}
