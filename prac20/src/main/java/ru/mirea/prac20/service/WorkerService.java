package ru.mirea.prac20.service;

import ru.mirea.prac20.entity.Worker;

public class WorkerService {
    private Worker worker;

    public WorkerService(Worker worker) {
        this.worker = worker;
    }

    public void doWork() {
        System.out.println("Worker " + worker.getName() + " start working");
        try {
            Thread.sleep(4000);
        }
        catch (Exception e) {}
        System.out.println("Worker " + worker.getName() + " end working");
    }

    public void doChill() {
        System.out.println("Worker " + worker.getName() + " start chilling");
        try {
            Thread.sleep(2000);
        }
        catch (Exception e) {}
        System.out.println("Worker " + worker.getName() + " end chilling");
    }
}
