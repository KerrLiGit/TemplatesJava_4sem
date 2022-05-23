package ru.mirea.builder;

public class Car {
    private String engine;
    private String director;

    public void buildEngine(String engine) {
        this.engine = engine;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void print() {
        System.out.println(director + " with " + engine);
    }
}
