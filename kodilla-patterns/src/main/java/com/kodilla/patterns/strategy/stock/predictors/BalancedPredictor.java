package com.kodilla.patterns.strategy.stock.predictors;

import com.kodilla.patterns.strategy.stock.BuyPredictor;

public class BalancedPredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[Balanced predictor] Buy shared units of Fund XYZ";
    }
}
