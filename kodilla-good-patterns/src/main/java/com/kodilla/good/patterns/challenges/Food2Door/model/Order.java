package com.kodilla.good.patterns.challenges.Food2Door.model;

import java.util.Objects;

public class Order {
    private final Product product;
    private final int productQuantity;

    public Order(Product product, int productQuantity) {
        this.product = product;
        this.productQuantity = productQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return productQuantity == order.productQuantity &&
                Objects.equals(product, order.product);
    }

    @Override
    public int hashCode() {

        return Objects.hash(product, productQuantity);
    }
}
