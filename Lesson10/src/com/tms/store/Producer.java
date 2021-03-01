package com.tms.store;

public class Producer extends Thread {
    private final Store store;
    private int goodsToPutCount;

    public Producer(Store store, int goodsToPutCount) {
        this.store = store;
        this.goodsToPutCount = goodsToPutCount;
    }

    @Override
    public void run() {
        try {
            while (goodsToPutCount > 0) {
                goodsToPutCount -= store.put();
                System.out.println(goodsToPutCount + " goods left to put");
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
    }
}
