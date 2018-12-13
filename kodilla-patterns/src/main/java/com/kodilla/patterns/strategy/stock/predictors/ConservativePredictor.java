package com.kodilla.patterns.strategy.stock.predictors;

import com.kodilla.patterns.strategy.stock.BuyPredictor;

public class ConservativePredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[Conservative predictor] Buy debentures of XYZ";
    }
}