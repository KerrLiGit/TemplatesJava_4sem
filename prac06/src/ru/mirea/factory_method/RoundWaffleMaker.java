package ru.mirea.factory_method;

public class RoundWaffleMaker implements WaffleMaker {
    @Override
    public Waffle factoryMethod() {
        return new RoundWaffle();
    }
}
