package com.kodilla.good.patterns.challenges.three.producers;

import com.kodilla.good.patterns.challenges.three.OrderForProducer;
import com.kodilla.good.patterns.challenges.three.Product;
import com.kodilla.good.patterns.challenges.three.confirmationservices.DocConfirmation;
import com.kodilla.good.patterns.challenges.three.confirmationservices.OrderConfirmationService;

import java.util.Map;

public class ExtraFoodShopProducer implements Producer {

    @Override
    public String toString() {
        return "ExtraFoodShop";
    }

    @Override
    public boolean process(OrderForProducer order) {
        OrderConfirmationService docConfirmation = new DocConfirmation();
        System.out.println("\r\n HealthyShop processes order: ");
        for(Map.Entry<Product, Integer> entry : order.getOrderedGoods().entrySet()){
            System.out.println(entry.getKey().getName() + " x " + entry.getValue());
        }
        docConfirmation.confirmOrder();

        return true;
    }
}
