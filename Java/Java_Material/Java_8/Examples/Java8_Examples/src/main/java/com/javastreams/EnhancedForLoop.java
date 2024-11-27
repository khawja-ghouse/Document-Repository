package com.javastreams;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class EnhancedForLoop {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1,2,3,4,5);

        // without streams.
        // It's called external iterations they fetch value outside
//        for (int i = 0; i < integerList.size(); i++) {
//            System.out.println(integerList.get(i));
//        }
//
//        Iterator<Integer> i = integerList.iterator();
//        while (i.hasNext())
//            System.out.println(i.next());
//
//        for (Integer j: integerList){
//            System.out.println(j);
//        }

        // With streams. Internal iterations
        System.out.println("With streams");


        // Understanding Consumer in details
//        Consumer<Integer> c = new Consumer<Integer>() {
//            @Override
//            public void accept(Integer i) {
//             System.out.println(i);
//            }
//        };

        // Above Anonimus inner class can also be written as shown below
        // Consumer<Integer> c = (Integer i) -> System.out.println(i);

        // Also this can be replaced with method reference

        // Finally this can also be written as shown below.
//        integerList.forEach((Integer i) -> System.out.println(i));

        integerList.forEach(System.out::println);
    }
}
