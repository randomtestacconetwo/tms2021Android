package com.tms.store;

public class Store {
    private int goodsCounter;
    private final int goodsLimit;

    public Store(int goodsLimit) {
        this.goodsLimit = goodsLimit;
    }

    /**
     * @return 1 if good was added, 0 if counter reached limit
     */
    synchronized int put() {
        if (goodsCounter < goodsLimit) {
            goodsCounter++;
            System.out.println("Store has " + goodsCounter + " goods");
            return 1;
        }
        return 0;
    }

    /**
     * @return 1 if good was removed, 0 if counter is 0
     */
    synchronized int get() {
        if (goodsCounter > 0) {
            goodsCounter--;
            System.out.println("Store has " + goodsCounter + " goods");
            return 1;
        }
        return 0;
    }

    public int getGoodsCounter() {
        return goodsCounter;
    }
}
