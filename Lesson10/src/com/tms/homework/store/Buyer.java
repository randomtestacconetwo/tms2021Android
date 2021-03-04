package com.tms.homework.store;

import com.tms.homework.store.choose.ChooseCashBoxStrategy;

public class Buyer extends Thread {
    private final Shop shop;
    private final String buyerName;
    private final String[] shoppingList;
    private final ChooseCashBoxStrategy strategy;

    public Buyer(Shop shop, String buyerName, String[] shoppingList, ChooseCashBoxStrategy strategy) {
        this.shop = shop;
        this.buyerName = buyerName;
        this.shoppingList = shoppingList;
        this.strategy = strategy;
    }

    @Override
    public void run() {
        CashBox box = strategy.chooseCashBox(buyerName, shop.getCashBoxes());
        System.out.println(buyerName + " will use CashBox #" + box.getId());
        box.serveBuyer(this);
    }

    public String[] getShoppingList() {
        return shoppingList;
    }

    public String getBuyerName() {
        return buyerName;
    }
}
