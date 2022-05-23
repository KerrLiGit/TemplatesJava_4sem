package ru.mirea;

import ru.mirea.bridge.*;
import ru.mirea.composite.Archer;
import ru.mirea.composite.CompositeUnit;
import ru.mirea.composite.Horseman;
import ru.mirea.composite.Infantryman;

public class Main {
    public static void main(String[] args) {
        test(new Red());
        test(new Blue());

        CompositeUnit archerBlock = new CompositeUnit();
        for (int i = 0; i < 10; i++) {
            archerBlock.add(new Archer());
        }
        CompositeUnit infantryBlock = new CompositeUnit();
        for (int i = 0; i < 20; i++) {
            infantryBlock.add(new Infantryman());
        }
        CompositeUnit horsemanBlock = new CompositeUnit();
        for (int i = 0; i < 5; i++) {
            horsemanBlock.add(new Horseman());
        }
        CompositeUnit army = new CompositeUnit();
        for (int i = 0; i < 5; i++) {
            army.add(archerBlock);
        }
        for (int i = 0; i < 10; i++) {
            army.add(infantryBlock);
        }
        for (int i = 0; i < 10; i++) {
            army.add(horsemanBlock);
        }
        System.out.println(army.getStrength());
    }

    public static void test(Color color) {
        Circle circle = new Circle(color);
        circle.print();
        Rectangle rect = new Rectangle(color);
        rect.print();
    }
}

