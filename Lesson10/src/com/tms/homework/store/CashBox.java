package com.tms.homework.store;

public class CashBox {
    private static int cashBoxCounter = 0;
    private final int id;
    private Integer queueSize = 0;
    private final Object lock = new Object();

    public CashBox() {
        id = cashBoxCounter++;
    }

    public void serveBuyer(Buyer buyer) {
        increaseQueSize();

        synchronized (this) {
            System.out.printf("CashBox #%s serves buyer %s\n", id, buyer.getBuyerName());
            for (String good : buyer.getShoppingList()) {
                System.out.printf("Buyer %s buys %s\n", buyer.getBuyerName(), good);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                }
            }
            synchronized (lock) {
                queueSize--;
                System.out.println("Buyer " + buyer.getBuyerName() + " is served. CashBox #" + id + " has "
                        + queueSize + " buyers left in the queue");
            }
        }
    }

    private void increaseQueSize() {
        synchronized (lock) {
            queueSize++;
            System.out.println("CashBox #" + id + " Queue increased to size " + queueSize);
        }
    }

    public int getId() {
        return id;
    }

    public int getQueueSize() {
        return queueSize;
    }
}
