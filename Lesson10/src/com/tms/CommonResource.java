package com.tms;

public class CommonResource {
    public volatile Integer x = 0;
    public Integer y = 0;

    public void increment() {
        synchronized (x) {
            x = 0;
            for (int i = 1; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " " + x);
                x++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                }
            }
        }
        synchronized (y) {
            //work with y
        }
    }

    public void doSmth() {
        synchronized (x) {
            //some work
        }
    }
}
