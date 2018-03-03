package com.kodilla.good.patterns.challenges.Food2Door.model;

public class OrderDto {

    private final Product product;
    private final int quantity;

    public OrderDto(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
