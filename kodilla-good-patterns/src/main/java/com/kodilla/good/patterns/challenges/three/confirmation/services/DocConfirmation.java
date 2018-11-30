package com.kodilla.good.patterns.challenges.three.confirmation.services;

public class DocConfirmation implements OrderConfirmationService {
    @Override
    public void confirmOrder() {
        System.out.println("Creating Doc confirmation");
    }
}
