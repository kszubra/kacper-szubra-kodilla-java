package com.kodilla.good.patterns.challenges.three.website.basket;

import com.kodilla.good.patterns.challenges.three.OrderForProducer;
import com.kodilla.good.patterns.challenges.three.User;
import com.kodilla.good.patterns.challenges.three.producers.Producer;
import com.kodilla.good.patterns.challenges.three.user.information.services.InformWebsiteUserService;

import java.util.Map;

public class WebsiteBasketProcessor {

    public static WebsiteBasketProcessingTDO processWebsiteBakset(WebsiteBasket basket) {

        WebsiteBasketProcessingTDO basketProcessingResult = new WebsiteBasketProcessingTDO();
        System.out.println("Processing basket: sending orders to products' producers:");

        for(Map.Entry<Producer, OrderForProducer> entry : basket.getOrdersInBasket().entrySet())  {
            basketProcessingResult.addRecord(entry.getKey(), entry.getKey().process(entry.getValue()));
        }
        return basketProcessingResult;
    }

    public static void informUser(User user, String message, InformWebsiteUserService informationService) {
        informationService.informUser(user, message);
    }


}
