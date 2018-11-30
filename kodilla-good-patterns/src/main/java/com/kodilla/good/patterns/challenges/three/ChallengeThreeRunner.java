package com.kodilla.good.patterns.challenges.three;

import com.kodilla.good.patterns.challenges.three.userinformationservices.EmailInformationService;
import com.kodilla.good.patterns.challenges.three.websitebasket.WebsiteBasket;
import com.kodilla.good.patterns.challenges.three.websitebasket.WebsiteBasketCreator;
import com.kodilla.good.patterns.challenges.three.websitebasket.WebsiteBasketProcessingTDO;
import com.kodilla.good.patterns.challenges.three.websitebasket.WebsiteBasketProcessor;


public class ChallengeThreeRunner {
    public static void main(String[] args) {

        WebsiteBasket exampleBasket = WebsiteBasketCreator.createExampleBasket();
        WebsiteBasketProcessingTDO processResult = WebsiteBasketProcessor.processWebsiteBakset(exampleBasket);
        WebsiteBasketProcessor.informUser(exampleBasket.getUser(), processResult.toString(), new EmailInformationService());

    }
}
