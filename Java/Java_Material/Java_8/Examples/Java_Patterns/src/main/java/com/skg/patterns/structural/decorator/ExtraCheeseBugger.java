package com.skg.patterns.structural.decorator;

public class ExtraCheeseBugger extends  BurgerDecorator{
    private final Burger burger;

    public ExtraCheeseBugger(Burger burger){
        this.burger = burger;
    }


    @Override
    public String getDescription() {
        return burger.getDescription() + "with extra cheese";
    }

    @Override
    public double getCost() {
        return burger.getCost()+ 10.0;
    }
}
