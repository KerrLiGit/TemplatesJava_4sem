package ru.mirea;

import java.util.HashMap;
import java.util.concurrent.Semaphore;

public class SMap {
    private static HashMap<String, String> map;
    private static final Semaphore semaphore = new Semaphore(1);

    public SMap() {
        map = new HashMap<String, String>();
    }

    public static void add(String key, String data) {
        try {
            semaphore.acquire();
            map.put(key, data);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void delete(String key) {
        try {
            semaphore.acquire();
            map.remove(key);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void change(String key, String data) {
        try {
            semaphore.acquire();
            map.put(key, data);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String find(String key) {
        String x = "";
        try {
            semaphore.acquire();
            x = map.get(key);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return x;
    }
}
