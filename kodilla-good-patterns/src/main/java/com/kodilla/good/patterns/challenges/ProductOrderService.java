package com.kodilla.good.patterns.challenges;

public class ProductOrderService {
    private UserInformationService userInformationService;
    private PurchaseService purchaseService;
    private TransactionRegistrationService transactionRegistrationService;

    public ProductOrderService(final UserInformationService userInformationService,
                               final PurchaseService purchaseService, final TransactionRegistrationService transactionRegistrationService) {

        this.userInformationService = userInformationService;
        this.purchaseService = purchaseService;
        this.transactionRegistrationService = transactionRegistrationService;
    }

    public void process(PurchaseRequest purchaseRequest) {
        boolean successfulPurchase = purchaseService.performPurchase(purchaseRequest.getBuyer(), purchaseRequest.getSeller(), purchaseRequest.getPurchaseProduct());
        if (successfulPurchase) {
            userInformationService.informUser(purchaseRequest.getBuyer(), "You bought " + purchaseRequest.getPurchaseProduct().getName());
            userInformationService.informUser(purchaseRequest.getSeller(), "You sold " + purchaseRequest.getPurchaseProduct().getName());
            transactionRegistrationService.recordTransaction(purchaseRequest);
        } else {
            System.out.println("Process failed");
        }
    }

}
