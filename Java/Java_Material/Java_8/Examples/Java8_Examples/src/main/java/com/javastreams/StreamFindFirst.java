package com.javastreams;

import java.util.Arrays;
import java.util.List;

public class StreamFindFirst {
    public static void main(String[] args) {

        // List with valid values divisible by 5
//        List<Integer> integerList = Arrays.asList(12,15,34,35,65,70,65,63,62);

        // List with no value is divisible by 5
        List<Integer> integerList = Arrays.asList(12,17,3,51,23,41,6,63,62);

        integerList.stream().filter(i -> i%5 == 0).forEach(System.out::println);

        System.out.println(integerList.stream()
                .filter(i -> i%5 == 0)
                .map(i -> i*3)
                .findFirst()
                .orElse(0));
    }
}
