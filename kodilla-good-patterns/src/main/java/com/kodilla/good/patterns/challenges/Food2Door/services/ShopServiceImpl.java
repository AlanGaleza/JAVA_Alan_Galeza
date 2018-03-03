package com.kodilla.good.patterns.challenges.Food2Door.services;

import com.kodilla.good.patterns.challenges.Food2Door.model.Shop;

public class ShopServiceImpl implements ShopService {

    private final Shop shop;

    public ShopServiceImpl(Shop shop) {
        this.shop = shop;
    }

    @Override
    public boolean process() {
        System.out.println("Shop process: " + shop.getName());
        return true;
    }

    @Override
    public void shopInformation() {
        System.out.println("Shop information: " + shop.getShopInfo());

    }

    @Override
    public boolean productAvailability() {
        System.out.println("Product unavailable");
        return true;
    }
}
