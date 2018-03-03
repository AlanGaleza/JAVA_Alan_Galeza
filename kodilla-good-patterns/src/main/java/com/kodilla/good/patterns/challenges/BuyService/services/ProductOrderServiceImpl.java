package com.kodilla.good.patterns.challenges.BuyService.services;

import com.kodilla.good.patterns.challenges.BuyService.model.Order;
import com.kodilla.good.patterns.challenges.BuyService.model.OrderRequestDto;
import com.kodilla.good.patterns.challenges.BuyService.model.Product;
import com.kodilla.good.patterns.challenges.BuyService.repository.OrderRepository;
import com.kodilla.good.patterns.challenges.BuyService.services.ProductOrderService;

public class ProductOrderServiceImpl implements ProductOrderService {

    private final ProductDetailService productDetailService;
    private final OrderRepository orderRepository;

    public ProductOrderServiceImpl(ProductDetailService productDetailService, OrderRepository orderRepository) {
        this.productDetailService = productDetailService;
        this.orderRepository = orderRepository;
    }

    @Override
    public void order(OrderRequestDto orderRequestDto) {
        Product product = productDetailService.findProduct(orderRequestDto.getProduct().getProductId());

        if(orderRequestDto.getQuantity() > 0) {
            double totalPrice = orderRequestDto.getQuantity() * product.getProductPrice();

            orderRepository.save(new Order(product, orderRequestDto.getQuantity(), totalPrice));

            System.out.println("Order saved");

        } else {

            System.out.println("Order unavailable to save");

        }
    }
}
