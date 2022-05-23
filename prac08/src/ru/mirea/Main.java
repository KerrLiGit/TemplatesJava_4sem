package ru.mirea;

import ru.mirea.command.*;
import ru.mirea.iterator.Iterator;
import ru.mirea.iterator.List;
import ru.mirea.iterator.ListImpl;

public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        Command switchUp = new TurnOnLightCommand(light);
        Command switchDown = new TurnOffLightCommand(light);
        Switch s = new Switch(switchUp, switchDown);
        s.flipUp();
        s.flipDown();

        List list = new ListImpl();
        list.add("A");
        list.add("B");
        list.add("C");

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
        }
    }
}

