package com.kodillapatterns2.decorator.taxiportal;

import java.math.BigDecimal;

/***
 * Powyższy dekorator jest klasą abstrakcyjną, stanowi więc "bazę" do rozszerzania przez rzeczywiste dekoratory.
 * Dekorator implementuje taki sam interfejs, jaki jest implementowany przez delegata. Dekorator "opakowuje" klasę
 * delegata i jego metody swoimi własnymi - dodając do funkcjonalności delegata własną funkcjonalność.
 * Można powiedzieć, że "dekoruje" funkcjonalność delegata swoimi dodatkami.
 */

public abstract class AbstractTaxiOrderDecorator implements TaxiOrder {
    private final TaxiOrder taxiOrder;

    protected AbstractTaxiOrderDecorator(TaxiOrder taxiOrder) {
        this.taxiOrder=taxiOrder;
    }

    @Override
    public BigDecimal getCost() {
        return taxiOrder.getCost();
    }

    @Override
    public String getDescription() {
        return taxiOrder.getDescription();
    }
}
