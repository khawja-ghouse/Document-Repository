package com.javastreams;

import java.util.Arrays;
import java.util.List;

public class StreamFilterMethod {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(12,15,34,35,65,70,65,63,62);

//        int result = 0;
//        for (int i : integerList) {
//            if (i % 5 == 0 ){
//                result += i;
//            }
//        }
//
//        System.out.println(result);

        // Streams take care of how to do it, the dev should take care of what to do it.
       integerList.stream().filter(i -> i%5 == 0).forEach(System.out::println);

       System.out.println(integerList.stream()
                                     .filter(i -> i%5 == 0)
                                     .map(i -> i*3)
                                     .reduce(0,Integer::sum));
    }
}
