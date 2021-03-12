package com.tms.store.model;

import java.util.Comparator;

public enum ProductOrder {
    PRICE_ASC((o1, o2) -> o1.getPrice() - o2.getPrice()),
    PRICE_DESC((o1, o2) -> o2.getPrice() - o1.getPrice()),
    LINKED(null);

    private final Comparator<Product> productComparator;

    ProductOrder(Comparator<Product> productComparator) {
        this.productComparator = productComparator;
    }

    public Comparator<Product> getProductComparator() {
        return productComparator;
    }
}
