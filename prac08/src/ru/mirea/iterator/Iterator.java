package ru.mirea.iterator;

public interface Iterator {
    Object next();

    boolean hasNext();

    void first();

    void last();
}
