package com.skg.patterns.creational.factory;

public class OperatingSystemFactory {

    public OS getOSInstance(String osType){
        if (osType.equalsIgnoreCase("open"))
            return new Android();
        else if (osType.equalsIgnoreCase("close"))
            return new IOS();
        else
            return new Windows();
    }
}
