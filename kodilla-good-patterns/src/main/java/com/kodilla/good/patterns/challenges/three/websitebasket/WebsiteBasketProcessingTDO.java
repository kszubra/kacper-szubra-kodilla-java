package com.kodilla.good.patterns.challenges.three.websitebasket;

import com.kodilla.good.patterns.challenges.three.producers.Producer;

import java.util.HashMap;
import java.util.Map;

public class WebsiteBasketProcessingTDO {
    private Map<Producer, Boolean> websiteBasketProcessingResult;

    public WebsiteBasketProcessingTDO() {
        websiteBasketProcessingResult = new HashMap<>();
    }

    public Map<Producer, Boolean> getWebsiteBasketProcessingResult() {
        return websiteBasketProcessingResult;
    }

    public void addRecord(Producer producer, Boolean processResult) {
        websiteBasketProcessingResult.put(producer, processResult);
    }

    @Override
    public String toString() {
        return "Your order confirmatin status: "
                + websiteBasketProcessingResult +
                '}';
    }
}
