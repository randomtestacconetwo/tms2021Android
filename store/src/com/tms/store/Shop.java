package com.tms.store;

import com.tms.store.exception.NoSuchProductException;
import com.tms.store.exception.NotEnoughProductsException;
import com.tms.store.exception.ProductAlreadyRegisteredException;
import com.tms.store.model.Product;
import com.tms.store.model.ProductOrder;

import java.util.*;

public class Shop {
    private final Map<String, List<Product>> productsByType = new HashMap<>();
    private final Map<Product, Integer> productToCount = new LinkedHashMap<>();

    /**
     * Add product to the shop (count will be set 0)
     *
     * @throws ProductAlreadyRegisteredException if shop already has this product
     */
    public void addProduct(Product product) throws ProductAlreadyRegisteredException {
        if (productToCount.containsKey(product)) {
            throw new ProductAlreadyRegisteredException("Product with id " + product.getId() + " already registered");
        }
        productToCount.put(product, 0);
//        code

//        String type = product.getType();
//        if (!productsByType.containsKey(type)) {
//            productsByType.put(type, new LinkedList<>());
//        }
//        productsByType.get(type).add(product);

//        can replace code below:
        productsByType.computeIfAbsent(product.getType(), k -> new LinkedList<>())
                .add(product);
    }

    /**
     * Replace data of object with the same id as product.id with data from product
     *
     * @throws NoSuchProductException if there is no product with the same id as in product
     */
    public void editProduct(Product product) throws NoSuchProductException {
        Product old = getProductById(product.getId());
        productToCount.put(product, productToCount.remove(old));
        productsByType.get(old.getType()).remove(old);
        productsByType.computeIfAbsent(product.getType(), k -> new LinkedList<>())
                .add(product);
    }

    /**
     * Remove product with id productId from the shop
     *
     * @throws NoSuchProductException if there is no product with the same id as in product
     */
    public void removeProduct(int productId) throws NoSuchProductException {
        Product product = getProductById(productId);
        productToCount.remove(product);
        for (String type : getProductTypes()) {
            productsByType.get(type).remove(product);
        }
    }

    /**
     *
     * Increase count of product with id productId by count
     *
     * @throws NoSuchProductException if there is no product with the same id as in product
     */
    public void increaseProductCount(int productId, int count) throws NoSuchProductException {
        Product product = getProductById(productId);
        productToCount.compute(product, (p, v) -> v += count);
    }

    /**
     *
     * Decrease count of product with id productId by count
     *
     * @throws NotEnoughProductsException if product count < then requested count
     * @throws NoSuchProductException if there is no product with the same id as in product
     */
    public void buyProduct(int productId, int count) throws NotEnoughProductsException, NoSuchProductException {
        Product product = getProductById(productId);
        Integer productCount = productToCount.get(product);
        if (productCount < count) {
            throw new NotEnoughProductsException("Can't buy " + count + " units of product with id: " + product.getId() +
                    ". " + productCount + " units left");
        }
        productToCount.compute(product, (p, v) -> v -= count);
    }

    /**
     * @return products in the requested order
     */
    public Collection<Product> getProducts(ProductOrder order) {
        ArrayList<Product> products = new ArrayList<>(getProducts());
        if (order.getProductComparator() != null) {
            products.sort(order.getProductComparator());
        }
        return products;
    }

    private Product getProductById(int id) throws NoSuchProductException {
//        code

//        for (Product p : productCount.keySet()) {
//            if (p.getId() == id) {
//                return p;
//            }
//        }
//        throw new NoSuchProductException("There is no product with id " + id))

//        can replace code below:
        return productToCount.keySet().stream().filter(p -> p.getId() == id).findFirst()
                .orElseThrow(() -> new NoSuchProductException("There is no product with id " + id));
    }

    public int getProductCount(Product product) {
        return productToCount.get(product);
    }

    public Collection<Product> getProducts() {
        return productToCount.keySet();
    }

    public Collection<Product> getProducts(String type) {
        return productsByType.getOrDefault(type, new LinkedList<>());
    }

    public Collection<String> getProductTypes() {
        return productsByType.keySet();
    }
}
