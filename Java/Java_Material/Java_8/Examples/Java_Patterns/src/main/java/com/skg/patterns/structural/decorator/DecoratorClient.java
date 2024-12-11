package com.skg.patterns.structural.decorator;

public class DecoratorClient {

    public static void main(String[] args) {

        Burger burger = new ZingerBurger();
        System.out.println("Zinger Burger Description "+burger.getDescription());
        System.out.println("Zinger Burger Cost "+burger.getCost());

        burger = new ExtraCheeseBugger(burger);
        System.out.println("Zinger Burger Description "+burger.getDescription());
        System.out.println("Zinger Burger Cost "+burger.getCost());

        burger = new ExtraMayonees(burger);
        System.out.println("Zinger Burger Description "+burger.getDescription());
        System.out.println("Zinger Burger Cost "+burger.getCost());

    }
}
