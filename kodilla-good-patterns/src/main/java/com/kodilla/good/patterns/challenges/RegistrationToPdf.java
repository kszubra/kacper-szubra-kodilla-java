package com.kodilla.good.patterns.challenges;

public class RegistrationToPdf implements TransactionRegistrationService {
    @Override
    public void recordTransaction(PurchaseRequest purchaseRequest) {
        System.out.println("Creating PDF confirmation of the transaction");
    }
}
