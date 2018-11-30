package com.kodilla.good.patterns.challenges.three.producers;

import com.kodilla.good.patterns.challenges.three.OrderForProducer;
import com.kodilla.good.patterns.challenges.three.Product;
import com.kodilla.good.patterns.challenges.three.confirmationservices.OrderConfirmationService;
import com.kodilla.good.patterns.challenges.three.confirmationservices.PdfConfirmation;

import java.util.Map;

public class HealthyShopProducer implements Producer {

    @Override
    public String toString() {
        return "HealthyShop";
    }

    @Override
    public boolean process(OrderForProducer order) {
        OrderConfirmationService pdfConfirmation = new PdfConfirmation();
        System.out.println("\r\n HealthyShop processes order: ");
        for(Map.Entry<Product, Integer> entry : order.getOrderedGoods().entrySet()){
            System.out.println(entry.getKey().getName() + " x " + entry.getValue());
        }
        pdfConfirmation.confirmOrder();
        return true;
    }
}
