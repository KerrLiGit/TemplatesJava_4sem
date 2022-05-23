package ru.mirea.iterator;

// "iterator"
public class IterImpl implements Iterator {
    private List list;

    private int index;

    public IterImpl(List list) {
        index = 0;
        this.list = list;
    }

    @Override
    public Object next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < list.getSize();
    }

    @Override
    public void first() {
        index = 0;
    }

    @Override
    public void last() {
        index = list.getSize();
    }
}

