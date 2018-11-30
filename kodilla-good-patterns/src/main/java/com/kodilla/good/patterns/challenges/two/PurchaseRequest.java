package com.kodilla.good.patterns.challenges.two;

import java.time.LocalDateTime;

public class PurchaseRequest {

    private User buyer;
    private User seller;
    private Product purchaseProduct;
    private int amountOfPurchasedProducts;
    private LocalDateTime purchaseDate;

    public PurchaseRequest(User buyer, User seller, Product purchaseProduct, int amountOfPurchasedProducts, LocalDateTime purchaseDate) {
        this.buyer = buyer;
        this.seller = seller;
        this.purchaseProduct = purchaseProduct;
        this.amountOfPurchasedProducts = amountOfPurchasedProducts;
        this.purchaseDate = purchaseDate;
    }

    public User getBuyer() {
        return buyer;
    }

    public User getSeller() {
        return seller;
    }

    public Product getPurchaseProduct() {
        return purchaseProduct;
    }

    public int getAmountOfPurchasedProducts() {
        return amountOfPurchasedProducts;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }
}
