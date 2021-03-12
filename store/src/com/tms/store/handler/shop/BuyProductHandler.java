package com.tms.store.handler.shop;

import com.tms.store.Shop;
import com.tms.store.exception.NoSuchProductException;
import com.tms.store.exception.NotEnoughProductsException;
import com.tms.store.exception.InvalidProductDataException;
import com.tms.store.handler.MenuSelectionExceptionHandler;
import com.tms.store.reader.ProductReader;
import com.tms.store.writer.ReportWriter;

public class BuyProductHandler extends MenuSelectionExceptionHandler {
    private final Shop shop;
    private final ProductReader reader;

    public BuyProductHandler(Shop shop, ProductReader reader, ReportWriter writer) {
        super(writer);
        this.shop = shop;
        this.reader = reader;
    }

    @Override
    public void handle() {
        try {
            shop.buyProduct(reader.readId(), reader.readCount());
        } catch (NotEnoughProductsException | NoSuchProductException | InvalidProductDataException e) {
            handleException(e);
        }
    }
}
