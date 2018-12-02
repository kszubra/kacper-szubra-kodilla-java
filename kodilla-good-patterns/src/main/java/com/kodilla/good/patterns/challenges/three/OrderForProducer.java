package com.kodilla.good.patterns.challenges.three;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class OrderForProducer {
    private User user;
    private LocalDateTime orderDate;
    private Map<Product, Integer> orderedGoods;

    public OrderForProducer(User user) {
        this.user = user;
        this.orderDate = LocalDateTime.now();
        this.orderedGoods = new HashMap<>();
    }

    public User getUser() {
        return user;
    }

    public void addRecord(Product product, Integer amount) {
        orderedGoods.put(product, amount);
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public Map<Product, Integer> getOrderedGoods() {
        return orderedGoods;
    }
}
