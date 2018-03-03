package com.kodilla.good.patterns.challenges.BuyService.repository;

import com.kodilla.good.patterns.challenges.BuyService.model.Order;

public interface OrderRepository {

    boolean save(Order order);

}
