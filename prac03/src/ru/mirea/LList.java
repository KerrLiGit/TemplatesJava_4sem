package ru.mirea;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LList {
    private static ArrayList<String> list;
    private static final Lock lock = new ReentrantLock();

    public LList() {
        list = new ArrayList<String>();
    }

    public static void add(String data) {
        lock.lock();
        list.add(data);
        lock.unlock();
    }

    public static String get(int index) {
        lock.lock();
        String data = list.get(index);
        lock.unlock();
        return data;
    }

    public static boolean contains(String data) {
        lock.lock();
        boolean b = list.contains(data);
        lock.unlock();
        return b;
    }
}

