package com.kodilla.patterns.strategy.stock;

import com.kodilla.patterns.strategy.stock.predictors.AggressivePredictor;

/***
 * agresywną — dla młodych klientów indywidualnych
 */

public class IndividualYoungCustomer extends Customer {
    public IndividualYoungCustomer(String name) {
        super(name);
        this.buyPredictor = new AggressivePredictor();
    }
}
