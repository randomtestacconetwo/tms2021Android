package com.tms.store.model;

public class ProductReport {
    private final String productType;
    private final double avgPrice;

    public ProductReport(String productType, double avgPrice) {
        this.productType = productType;
        this.avgPrice = avgPrice;
    }

    public String getProductType() {
        return productType;
    }

    public double getAvgPrice() {
        return avgPrice;
    }
}
