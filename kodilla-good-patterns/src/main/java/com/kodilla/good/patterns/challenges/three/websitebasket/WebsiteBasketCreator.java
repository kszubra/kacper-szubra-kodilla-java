package com.kodilla.good.patterns.challenges.three.websitebasket;

import com.kodilla.good.patterns.challenges.three.OrderForProducer;
import com.kodilla.good.patterns.challenges.three.Product;
import com.kodilla.good.patterns.challenges.three.User;
import com.kodilla.good.patterns.challenges.three.producers.ExtraFoodShopProducer;
import com.kodilla.good.patterns.challenges.three.producers.GlutenFreeShopProducer;
import com.kodilla.good.patterns.challenges.three.producers.HealthyShopProducer;

public class WebsiteBasketCreator {

    public static WebsiteBasket createExampleBasket() {
        WebsiteBasket exampleBasket = new WebsiteBasket(new User("Bob"));
        OrderForProducer orderForHealthyShop = new OrderForProducer(exampleBasket.getUser());
        orderForHealthyShop.addRecord(new Product("Banana", "", 5), 3);
        orderForHealthyShop.addRecord(new Product("Apple", "", 2), 6);

        OrderForProducer orderForExtraFoodShop = new OrderForProducer(exampleBasket.getUser());
        orderForExtraFoodShop.addRecord(new Product("Veggie salad", "", 15), 1);
        orderForExtraFoodShop.addRecord(new Product("Grape juice", "", 8), 2);

        OrderForProducer orderForGlutenFreeShop = new OrderForProducer(exampleBasket.getUser());
        orderForGlutenFreeShop.addRecord(new Product("Gluten free water", "", 21), 1);
        orderForGlutenFreeShop.addRecord(new Product("Gluten free gluten", "", 99), 2);

        exampleBasket.addRecord(new HealthyShopProducer(), orderForHealthyShop);
        exampleBasket.addRecord(new ExtraFoodShopProducer(), orderForExtraFoodShop);
        exampleBasket.addRecord(new GlutenFreeShopProducer(), orderForGlutenFreeShop);

        return exampleBasket;
    }
}
