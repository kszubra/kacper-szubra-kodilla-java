package com.kodilla.good.patterns.challenges.two;

public class ChallengeTwoRunner {
    public static void main(String[] args) {
        PurchaseRequestRetriever purchaseRequestRetriever = new PurchaseRequestRetriever();
        PurchaseRequest purchaseRequest = purchaseRequestRetriever.getRequest();

        ProductOrderService productOrderService = new ProductOrderService(new PrivateMessageInformationService(), new WebPurchaseService(), new RegistrationToPdf());
        productOrderService.process(purchaseRequest);

    }
}
