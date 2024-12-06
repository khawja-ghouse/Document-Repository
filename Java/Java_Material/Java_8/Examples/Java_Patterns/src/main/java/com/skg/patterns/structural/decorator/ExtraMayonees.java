package com.skg.patterns.structural.decorator;

public class ExtraMayonees extends  BurgerDecorator{
    private final Burger burger;

    public ExtraMayonees(Burger burger){
        this.burger = burger;
    }


    @Override
    public String getDescription() {
        return burger.getDescription() + "with extra Mayonees";
    }

    @Override
    public double getCost() {
        return burger.getCost()+ 5.0;
    }
}
