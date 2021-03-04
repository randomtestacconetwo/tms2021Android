package com.tms.homework.store.choose;

import com.tms.homework.store.CashBox;

public interface ChooseCashBoxStrategy {
    CashBox chooseCashBox(String buyerName, CashBox[] cashBoxes);
}
