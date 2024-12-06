package com.skg.patterns.creational.factory;

public class Windows implements OS{
    @Override
    public void spec() {
        System.out.println("I am a stable OS");
    }
}
