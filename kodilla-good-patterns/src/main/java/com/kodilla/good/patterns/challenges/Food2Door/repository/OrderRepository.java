package com.kodilla.good.patterns.challenges.Food2Door.repository;

import com.kodilla.good.patterns.challenges.Food2Door.model.Order;

public interface OrderRepository {
    boolean save(Order order);

}
