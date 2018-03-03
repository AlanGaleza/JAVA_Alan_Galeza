package com.kodilla.good.patterns.challenges.Food2Door.services;

import com.kodilla.good.patterns.challenges.Food2Door.model.Order;
import com.kodilla.good.patterns.challenges.Food2Door.model.OrderDto;
import com.kodilla.good.patterns.challenges.Food2Door.repository.OrderRepository;
import com.kodilla.good.patterns.challenges.Food2Door.repository.OrderRepositoryImpl;

public class ContractRealizationImpl {

    private final RealizationStatusService realizationStatusService;
    private final ShopService shopService;

    public ContractRealizationImpl(RealizationStatusService realizationStatusService, ShopService shopService) {
        this.realizationStatusService = realizationStatusService;
        this.shopService = shopService;
    }

    public void orderRealization(OrderDto orderDto) {
        if(realizationStatusService.status()) {

            shopService.shopInformation();
            shopService.process();

            OrderRepository orderRepository = new OrderRepositoryImpl();
            orderRepository.save(new Order(orderDto.getProduct(), orderDto.getQuantity()));

        } else {

            System.out.println("UNAVAILABLE");


        }




    }


}
