package com.tms.store.handler.accounting;

import com.tms.store.Accounting;
import com.tms.store.handler.MenuSelectionHandler;
import com.tms.store.model.ProductReport;
import com.tms.store.writer.ReportWriter;

import java.util.Collection;

public class CalculateAvgProductPriceByTypeHandler implements MenuSelectionHandler {
    private final Accounting accounting;
    private final ReportWriter writer;

    public CalculateAvgProductPriceByTypeHandler(Accounting accounting, ReportWriter writer) {
        this.accounting = accounting;
        this.writer = writer;
    }

    @Override
    public void handle() {
        Collection<ProductReport> reports = accounting.calculateAvgPriceByType();
        if (reports.isEmpty()) {
            writer.write("There are no products in the shop");
        }
        for (ProductReport report : reports) {
            writer.write("Average price for type " + report.getProductType() + " is " + report.getAvgPrice());
        }
        writer.write("---------------------\n");
    }
}
