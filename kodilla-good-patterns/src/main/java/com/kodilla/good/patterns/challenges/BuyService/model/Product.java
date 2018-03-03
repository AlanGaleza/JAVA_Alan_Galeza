package com.kodilla.good.patterns.challenges.BuyService.model;

import java.util.Objects;

public class Product {

    private final String productName;
    private final long productId;
    private final double productPrice;
    private final Category productCategory;

    public Product(String productName, long productId, double productPrice, Category productCategory) {
        this.productName = productName;
        this.productId = productId;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
    }

    public String getProductName() {

        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public Category getProductCategory() {
        return productCategory;
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
                Double.compare(product.productPrice, productPrice) == 0 &&
                Objects.equals(productName, product.productName) &&
                productCategory == product.productCategory;
    }

    @Override
    public int hashCode() {

        return Objects.hash(productName, productId, productPrice, productCategory);
    }

}
