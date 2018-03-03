package com.kodilla.good.patterns.challenges.BuyService;

import com.kodilla.good.patterns.challenges.BuyService.model.Category;
import com.kodilla.good.patterns.challenges.BuyService.model.Order;
import com.kodilla.good.patterns.challenges.BuyService.model.OrderRequestDto;
import com.kodilla.good.patterns.challenges.BuyService.model.Product;
import com.kodilla.good.patterns.challenges.BuyService.repository.OrderRepository;
import com.kodilla.good.patterns.challenges.BuyService.repository.OrderRepositoryImpl;
import com.kodilla.good.patterns.challenges.BuyService.services.ProductDetailServiceImpl;
import com.kodilla.good.patterns.challenges.BuyService.services.ProductOrderService;
import com.kodilla.good.patterns.challenges.BuyService.services.ProductOrderServiceImpl;

public class Application {

    public static void main(String args[]) {
        Product product = new Product("PC", 1, 12.50, Category.electronics);
        OrderRequestDto orderRequestDto = new OrderRequestDto(product, 2);


        ProductOrderServiceImpl productOrderServiceImpl = new ProductOrderServiceImpl(new ProductDetailServiceImpl(), new OrderRepositoryImpl());
        productOrderServiceImpl.order(orderRequestDto);

    }

}
