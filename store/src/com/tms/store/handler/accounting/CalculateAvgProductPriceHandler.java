package com.tms.store.handler.accounting;

import com.tms.store.Accounting;
import com.tms.store.handler.MenuSelectionHandler;
import com.tms.store.writer.ReportWriter;

public class CalculateAvgProductPriceHandler implements MenuSelectionHandler {
    private final Accounting accounting;
    private final ReportWriter writer;

    public CalculateAvgProductPriceHandler(Accounting accounting, ReportWriter writer) {
        this.accounting = accounting;
        this.writer = writer;
    }

    @Override
    public void handle() {
        writer.write("Average product price is " + accounting.calculateAvgProductPrice());
        writer.write("---------------------\n");
    }
}
