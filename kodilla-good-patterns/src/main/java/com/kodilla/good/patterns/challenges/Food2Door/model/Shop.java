package com.kodilla.good.patterns.challenges.Food2Door.model;

import java.util.Objects;

public class Shop {

    private final String name;
    private final String shopInfo;

    public Shop(String name, String shopInfo) {
        this.name = name;
        this.shopInfo = shopInfo;
    }

    public String getName() {
        return name;
    }

    public String getShopInfo() {
        return shopInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Objects.equals(name, shop.name) &&
                Objects.equals(shopInfo, shop.shopInfo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, shopInfo);
    }
}
