package ru.mirea.bridge;

public class Circle implements Figure {
    Color color;

    public Circle(Color color) {
        this.color = color;
    }

    @Override
    public void print() {
        color.print();
        System.out.println("Circle");
    }
}