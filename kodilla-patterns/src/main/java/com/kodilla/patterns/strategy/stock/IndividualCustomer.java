package com.kodilla.patterns.strategy.stock;

import com.kodilla.patterns.strategy.stock.predictors.ConservativePredictor;

/***
 * zachowawczą — dla dojrzałych klientów indywidualnych
 */

public class IndividualCustomer extends Customer {
    public IndividualCustomer(String name) {
        super(name);
        this.buyPredictor = new ConservativePredictor();
    }
}