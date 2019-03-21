package com.kodillapatterns2.decorator.pizza;

import java.math.BigDecimal;

public class JalapenoPizzaDecorator extends AbstractPizzaOrderDecorator {

    public JalapenoPizzaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(2.50));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", jalapeno";
    }
}
