package ru.mirea.factory_method;

public class RoundWaffle implements Waffle {
    @Override
    public void print() {
        System.out.println("Круглая вафля");
    }
}
