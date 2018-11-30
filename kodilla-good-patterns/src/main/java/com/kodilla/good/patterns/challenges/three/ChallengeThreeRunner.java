package com.kodilla.good.patterns.challenges.three;

import com.kodilla.good.patterns.challenges.three.user.information.services.EmailInformationService;
import com.kodilla.good.patterns.challenges.three.website.basket.WebsiteBasket;
import com.kodilla.good.patterns.challenges.three.website.basket.WebsiteBasketCreator;
import com.kodilla.good.patterns.challenges.three.website.basket.WebsiteBasketProcessingTDO;
import com.kodilla.good.patterns.challenges.three.website.basket.WebsiteBasketProcessor;


public class ChallengeThreeRunner {
    public static void main(String[] args) {

        WebsiteBasket exampleBasket = WebsiteBasketCreator.createExampleBasket();
        WebsiteBasketProcessingTDO processResult = WebsiteBasketProcessor.processWebsiteBakset(exampleBasket);
        WebsiteBasketProcessor.informUser(exampleBasket.getUser(), processResult.toString(), new EmailInformationService());

    }
}
