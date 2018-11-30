package com.kodilla.good.patterns.challenges.three.producers;

import com.kodilla.good.patterns.challenges.three.OrderForProducer;
import com.kodilla.good.patterns.challenges.three.Product;
import com.kodilla.good.patterns.challenges.three.confirmation.services.DocConfirmation;
import com.kodilla.good.patterns.challenges.three.confirmation.services.OrderConfirmationService;
import com.kodilla.good.patterns.challenges.three.confirmation.services.PdfConfirmation;

import java.util.Map;

public class GlutenFreeShopProducer implements Producer {

    @Override
    public String toString() {
        return "GlutenFreeShop";
    }

    @Override
    public boolean process(OrderForProducer order) {
        OrderConfirmationService pdfConfirmation = new PdfConfirmation();
        OrderConfirmationService docConfirmation = new DocConfirmation();
        System.out.println("\r\n HealthyShop processes order: ");
        for(Map.Entry<Product, Integer> entry : order.getOrderedGoods().entrySet()){
            System.out.println(entry.getKey().getName() + " x " + entry.getValue());
        }
        pdfConfirmation.confirmOrder();
        docConfirmation.confirmOrder();
        return true;
    }
}
