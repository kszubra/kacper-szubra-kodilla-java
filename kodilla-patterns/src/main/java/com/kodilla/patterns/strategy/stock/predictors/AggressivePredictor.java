package com.kodilla.patterns.strategy.stock.predictors;

import com.kodilla.patterns.strategy.stock.BuyPredictor;

public class AggressivePredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[Aggressive predictor] Buy stock of XYZ";
    }
}
