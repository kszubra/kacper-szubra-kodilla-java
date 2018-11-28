package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class PurchaseRequestRetriever {

    public PurchaseRequest getRequest() {

        return new PurchaseRequest(
                new User("John Rambo"),
                new User ("Terminator"),
                new Product("Tactical Slippers", "Nuclear bulletproof slippers saving Colonel Trautman", 99999),
                1,
                LocalDateTime.now());
    }
}
