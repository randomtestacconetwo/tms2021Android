package com.tms.store.handler.accounting;

import com.tms.store.Accounting;
import com.tms.store.handler.MenuSelectionHandler;
import com.tms.store.writer.ReportWriter;

public class GetTotalProductsCountHandler implements MenuSelectionHandler {
    private final Accounting accounting;
    private final ReportWriter writer;

    public GetTotalProductsCountHandler(Accounting accounting, ReportWriter writer) {
        this.accounting = accounting;
        this.writer = writer;
    }

    @Override
    public void handle() {
        writer.write("There are " + accounting.calculateTotalProductsCount() + " products in total");
        writer.write("---------------------\n");
    }
}
