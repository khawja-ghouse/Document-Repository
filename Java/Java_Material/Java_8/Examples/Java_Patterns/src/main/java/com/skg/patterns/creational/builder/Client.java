package com.skg.patterns.creational.builder;

public class Client {
    public static void main(String[] args) {

        ComputerBuilder desktopBuilder = new DesktopComputerBuilder();

//        Computer desktop = desktopBuilder
//                .buildProcessor("Intel i7")
//                .buildMemory(16)
//                .buildStorage(512)
//                .buildGraphicsCard("NVIDIA GTX 1660")
//                .build();

        // Access the constructed Computer object
//        System.out.println(desktop);

        ComputerDirector computerDirector = new ComputerDirector(desktopBuilder);

        System.out.println(computerDirector.constructComputer());
    }
}
