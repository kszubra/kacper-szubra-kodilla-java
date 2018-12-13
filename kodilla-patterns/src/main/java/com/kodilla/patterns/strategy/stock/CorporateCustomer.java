package com.kodilla.patterns.strategy.stock;

import com.kodilla.patterns.strategy.stock.predictors.BalancedPredictor;

/***
 * zrównoważoną — dla klientów korporacyjnych
 */

public class CorporateCustomer extends Customer {
    public CorporateCustomer(String name) {
        super(name);
        this.buyPredictor = new BalancedPredictor();
    }
}