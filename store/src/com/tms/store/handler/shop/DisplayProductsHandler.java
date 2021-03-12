package com.tms.store.handler.shop;

import com.tms.store.Shop;
import com.tms.store.handler.MenuSelectionExceptionHandler;
import com.tms.store.handler.MenuSelectionHandler;
import com.tms.store.model.ProductOrder;
import com.tms.store.writer.ReportWriter;

public class DisplayProductsHandler implements MenuSelectionHandler {
    private final Shop shop;
    private final ProductOrder order;
    private final ReportWriter writer;
    private final StringBuilder builder = new StringBuilder();

    public DisplayProductsHandler(Shop shop, ProductOrder order, ReportWriter writer) {
        this.shop = shop;
        this.order = order;
        this.writer = writer;
    }

    @Override
    public void handle() {
        builder.setLength(0);
        shop.getProducts(order).forEach(p -> builder.append(p).append("\n"));
        writer.write(builder.toString());
        writer.write("---------------------\n");
    }
}
