package ru.mirea;

public class Main {
    public static void main(String[] args) {
        MyExecutorService executorService = new MyExecutorService(2);
        executorService.execute(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Second");
        });

        executorService.execute(() -> System.out.println("First"));
        executorService.shutdown();
    }
}
