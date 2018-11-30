package com.kodilla.good.patterns.challenges.three.confirmationservices;

import java.io.ObjectOutputStream;

public class PdfConfirmation implements OrderConfirmationService {

    @Override
    public void confirmOrder() {
        System.out.println("Creating PDF with confirmation");
    }
}
