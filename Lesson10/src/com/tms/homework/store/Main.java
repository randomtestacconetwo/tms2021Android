package com.tms.homework.store;

import com.tms.homework.store.choose.LeastQueueCashBoxStrategy;
import com.tms.homework.store.choose.RandomCashBoxStrategy;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Shop shop = new Shop(3);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Buyer b = new Buyer(shop, "B" + i, new String[]{"Вода", "Колбаса"},
                    random.nextInt(2) == 0 ? new LeastQueueCashBoxStrategy() : new RandomCashBoxStrategy());
            b.start();
            Thread.sleep(100);
        }
    }
}
