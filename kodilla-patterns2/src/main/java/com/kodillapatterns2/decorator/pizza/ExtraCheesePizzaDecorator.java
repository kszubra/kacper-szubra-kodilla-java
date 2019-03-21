package com.kodillapatterns2.decorator.pizza;

import java.math.BigDecimal;

public class ExtraCheesePizzaDecorator extends AbstractPizzaOrderDecorator {

    public ExtraCheesePizzaDecorator(PizzaOrder order) {
        super(order);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(2.00));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", extra cheese";
    }
}
