package ru.mirea.composite;

import java.util.ArrayList;

public class CompositeUnit implements Unit {
    private ArrayList<Unit> comp;

    public CompositeUnit() {
        comp = new ArrayList<Unit>();
    }

    public int getStrength() {
        int strength = 0;
        for (Unit i : comp) {
            strength += i.getStrength();
        }
        return strength;
    }

    public void add(Unit unit) {
        comp.add(unit);
    }

    public void remove(Unit unit) {
        comp.remove(unit);
    }
}

