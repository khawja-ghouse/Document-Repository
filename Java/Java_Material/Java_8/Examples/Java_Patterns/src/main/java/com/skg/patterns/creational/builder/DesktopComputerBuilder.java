package com.skg.patterns.creational.builder;

public class DesktopComputerBuilder implements ComputerBuilder {

    private Computer computer;

    public DesktopComputerBuilder(){
        this.computer = new Computer();
    }

    @Override
    public ComputerBuilder buildProcessor(String processor) {
        this.computer.setProcessor(processor);
        return this;
    }

    @Override
    public ComputerBuilder buildMemory(int memory) {
        this.computer.setMemory(memory);
        return this;
    }

    @Override
    public ComputerBuilder buildStorage(int storage) {
        this.computer.setStorage(storage);
        return this;
    }

    @Override
    public ComputerBuilder buildGraphicsCard(String graphicsCard) {
        this.computer.setGraphicsCard(graphicsCard);
        return this;
    }

    @Override
    public Computer build() {
        return this.computer;
    }
}
