package com.kodilla.good.patterns.challenges.Food2Door;

import com.kodilla.good.patterns.challenges.Food2Door.model.OrderDto;
import com.kodilla.good.patterns.challenges.Food2Door.model.Product;
import com.kodilla.good.patterns.challenges.Food2Door.model.Shop;
import com.kodilla.good.patterns.challenges.Food2Door.services.*;

public class Application {
    public static void main(String args[]){

        Shop healthyShop = new Shop("HealthlyShop", "Shop policy");
        Product product = new Product("PC", 1234);
        OrderDto orderDto = new OrderDto(product, 1);

        ContractRealizationImpl contractRealizationImpl = new ContractRealizationImpl(new RealizationStatusServiceImpl(), new ShopServiceImpl(healthyShop));

        contractRealizationImpl.orderRealization(orderDto);

    }
}
