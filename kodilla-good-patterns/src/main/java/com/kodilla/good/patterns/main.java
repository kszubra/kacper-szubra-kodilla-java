package com.kodilla.good.patterns;

import com.kodilla.good.patterns.challenges.*;

public class main {
    public static void main(String[] args) {
        PurchaseRequestRetriever purchaseRequestRetriever = new PurchaseRequestRetriever();
        PurchaseRequest purchaseRequest = purchaseRequestRetriever.getRequest();

        ProductOrderService productOrderService = new ProductOrderService(new PrivateMessageInformationService(), new WebPurchaseService(), new RegistrationToPdf());
        productOrderService.process(purchaseRequest);

    }
}
