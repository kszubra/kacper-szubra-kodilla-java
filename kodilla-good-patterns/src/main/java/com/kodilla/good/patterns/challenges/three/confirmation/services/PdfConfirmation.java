package com.kodilla.good.patterns.challenges.three.confirmation.services;

public class PdfConfirmation implements OrderConfirmationService {

    @Override
    public void confirmOrder() {
        System.out.println("Creating PDF with confirmation");
    }
}
