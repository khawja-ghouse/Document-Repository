package com.skg.patterns.creational.factory;

public class Factory {

    public static void main(String[] args) {

        OperatingSystemFactory factory = new OperatingSystemFactory();
        OS os = factory.getOSInstance("Close");

        os.spec();
    }
}
