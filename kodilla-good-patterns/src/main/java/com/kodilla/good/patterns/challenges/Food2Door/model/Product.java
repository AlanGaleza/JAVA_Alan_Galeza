package com.kodilla.good.patterns.challenges.Food2Door.model;

import java.util.Objects;

public class Product {

    private final String productName;
    private final long productId;

    public Product(String productName, long productId) {
        this.productName = productName;
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public long getProductId() {
        return productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId &&
                Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(productName, productId);
    }
}
