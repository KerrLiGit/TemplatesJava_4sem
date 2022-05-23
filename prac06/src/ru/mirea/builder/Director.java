package ru.mirea.builder;

public class Director {
    Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void Construct() {
        builder.BuildEngine();
        builder.SetDirector();
    }
}
