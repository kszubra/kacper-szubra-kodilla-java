package com.kodilla.good.patterns.challenges;

public class WebPurchaseService implements PurchaseService {
    @Override
    public boolean performPurchase(User buyer, User seller, Product product) {
        //performs mechanics here
        System.out.println("Purchase successful. " + buyer.getUsername() + " bought " + product.getName() + " from " + seller.getUsername());
        return true;
    }
}
