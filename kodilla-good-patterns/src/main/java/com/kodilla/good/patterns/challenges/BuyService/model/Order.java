package com.kodilla.good.patterns.challenges.BuyService.model;

import java.util.Objects;

public class Order {

    private final Product product;
    private final int productQuantity;
    private final double orderTotalPrice;

    public Order(Product product, int productQuantity, double orderTotalPrice) {
        this.product = product;
        this.productQuantity = productQuantity;
        this.orderTotalPrice = orderTotalPrice;
    }

    public Product getProduct() {

        return product;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public double getOrderTotalPrice() {
        return orderTotalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return  productQuantity == order.productQuantity &&
                Double.compare(order.orderTotalPrice, orderTotalPrice) == 0 &&
                Objects.equals(product, order.product);
    }

    @Override
    public int hashCode() {

        return Objects.hash(product, productQuantity, orderTotalPrice);
    }

    @Override
    public String toString() {
        return "Order{ " +
                "product = " + product +
                ", productQuantity = " + productQuantity +
                ", orderTotalPrice = " + orderTotalPrice +
                '}';
    }
}
