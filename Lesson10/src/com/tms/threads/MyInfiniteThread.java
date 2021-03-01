package com.tms.threads;

public class MyInfiniteThread extends Thread {

    public MyInfiniteThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " started");
        int i = 0;
        while (!isInterrupted()) {
            System.out.println("Iteration " + i++);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
                break;
            }
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " ended");
    }
}
