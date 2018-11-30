package com.kodilla.good.patterns.challenges.three.websitebasket;

import com.kodilla.good.patterns.challenges.three.OrderForProducer;
import com.kodilla.good.patterns.challenges.three.User;
import com.kodilla.good.patterns.challenges.three.producers.Producer;

import java.util.HashMap;
import java.util.Map;

public class WebsiteBasket {
    private User user;
    private Map<Producer, OrderForProducer> ordersInBasket;
    private double basketValue;

    public WebsiteBasket(User user) {
        this.user = user;
        this.ordersInBasket = new HashMap<>();
        this.basketValue = 0.0;
    }

    public User getUser() {
        return user;
    }

    public Map<Producer, OrderForProducer> getOrdersInBasket() {
        return ordersInBasket;
    }

    public void addRecord(Producer producer, OrderForProducer order) {
        ordersInBasket.put(producer, order);
    }

    public double getBasketValue() {
        return basketValue;
    }
}
