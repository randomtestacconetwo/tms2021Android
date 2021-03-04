package com.tms.homework.store.choose;

import com.tms.homework.store.CashBox;

import java.util.Random;

public class RandomCashBoxStrategy implements ChooseCashBoxStrategy {
    private final Random random = new Random();

    @Override
    public CashBox chooseCashBox(String customerName, CashBox[] cashBoxes) {
        System.out.println(customerName + " picking CashBox randomly");
        return cashBoxes[random.nextInt(cashBoxes.length)];
    }
}
