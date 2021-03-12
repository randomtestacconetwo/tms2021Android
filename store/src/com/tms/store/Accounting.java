package com.tms.store;

import com.tms.store.model.Product;
import com.tms.store.model.ProductReport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Accounting {
    private final Shop shop;

    public Accounting(Shop shop) {
        this.shop = shop;
    }

    public Collection<String> getProductTypes() {
        return shop.getProductTypes();
    }

    /**
     * @return sum of all product count all over the shop.
     * Example: if shop has 3 pencils (type pencil) and 10 apples(type fruit) method will return 13
     */
    public int calculateTotalProductsCount() {
        return calculateTotalProductCount(shop.getProducts());
    }

    /**
     * @return avg product price all over the shop. (sum of all product / count of all products)
     * Example: if shop has 3 pencils (type pencil, price 5) and 10 apples(type fruit, price 1)
     * method will return ~1.9 (sum of all products - 25 (5 * 3 + 10 * 1), count of all products = 13 (3 + 10)
     */
    public double calculateAvgProductPrice() {
        long totalProductsSum = calculateTotalProductSum(shop.getProducts());
        int totalProductsCount = calculateTotalProductsCount();
        if (totalProductsCount == 0) {
            return 0;
        }
        return totalProductsSum / (double) totalProductsCount;
    }

    /**
     * Same calculation as in {@link #calculateAvgProductPrice()}, but instead of (sum of all product / count of all products)
     * method will calculate (sum of all product of exact type / count of all products of exact type) for each type
     */
    public Collection<ProductReport> calculateAvgPriceByType() {
        List<ProductReport> reports = new ArrayList<>(shop.getProductTypes().size());
        for (String type : shop.getProductTypes()) {
            Collection<Product> products = shop.getProducts(type);
            int count = calculateTotalProductCount(products);
            if (count == 0) continue;
            double avgPrice = (double) calculateTotalProductSum(products) / count;
            reports.add(new ProductReport(type, avgPrice));
        }
        return reports;
    }

    private long calculateTotalProductSum(Collection<Product> products) {
//        code

//        long totalProductsSum = 0;
//        for (Product product : products {
//            totalProductsSum += (long) product.getPrice() * shop.getProductCount(product);
//        }
//        return totalProductsSum;

//        can replace code below:
        return products.stream().reduce(0L,
                (res, product) -> res + (long) product.getPrice() * shop.getProductCount(product), Long::sum);
    }

    private int calculateTotalProductCount(Collection<Product> products) {
//        code

//        int sum = 0;
//        for (Product product : products) {
//            sum += shop.getProductCount(product);
//        }
//        return sum;

//        can replace code below:
        return products.stream().reduce(0,
                (res, product) -> res + shop.getProductCount(product), Integer::sum);
    }
}
