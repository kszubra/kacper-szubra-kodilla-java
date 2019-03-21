package com.kodillapatterns2.decorator.pizza;

import java.math.BigDecimal;

public class OlivesPizzaDecorator extends AbstractPizzaOrderDecorator {

    public OlivesPizzaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(0.85));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", olives";
    }
}
