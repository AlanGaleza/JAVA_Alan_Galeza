package com.kodilla.good.patterns.challenges.BuyService.services;

import com.kodilla.good.patterns.challenges.BuyService.model.Category;
import com.kodilla.good.patterns.challenges.BuyService.model.Product;

public class ProductDetailServiceImpl implements ProductDetailService {

    @Override
    public Product findProduct(long productId) {
        return new Product("PC", 1, 12.50, Category.electronics);
    }
}
