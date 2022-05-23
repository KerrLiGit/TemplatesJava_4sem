package ru.mirea.bridge;

public class Rectangle implements Figure {
    Color color;

    public Rectangle(Color color) {
        this.color = color;
    }

    @Override
    public void print() {
        color.print();
        System.out.println("Rectangle");
    }
}