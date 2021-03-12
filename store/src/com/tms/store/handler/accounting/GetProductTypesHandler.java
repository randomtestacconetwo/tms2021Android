package com.tms.store.handler.accounting;

import com.tms.store.Accounting;
import com.tms.store.handler.MenuSelectionHandler;
import com.tms.store.writer.ReportWriter;

import java.util.Collection;

public class GetProductTypesHandler implements MenuSelectionHandler {
    private final Accounting accounting;
    private final ReportWriter writer;

    public GetProductTypesHandler(Accounting accounting, ReportWriter writer) {
        this.accounting = accounting;
        this.writer = writer;
    }

    @Override
    public void handle() {
        Collection<String> types = accounting.getProductTypes();
        boolean multiple = types.size() != 1;
        writer.write("There " + (multiple ? "are " : "is ")
                + types.size() + " type" + (multiple ? "s" : ""));
        if (types.size() > 0) {
            writer.write(types.toString());
        }
        writer.write("---------------------\n");
    }
}
