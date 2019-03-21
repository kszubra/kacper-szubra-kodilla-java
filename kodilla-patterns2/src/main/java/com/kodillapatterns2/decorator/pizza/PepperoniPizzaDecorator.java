package com.kodillapatterns2.decorator.pizza;

import java.math.BigDecimal;

public class PepperoniPizzaDecorator extends AbstractPizzaOrderDecorator {

    public PepperoniPizzaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(5.20));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", pepperoni";
    }
}
