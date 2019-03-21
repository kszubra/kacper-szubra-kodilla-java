package com.kodillapatterns2.decorator.pizza;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class PizzaOrderTestSuite {

    @Test
    public void testCreatingFancyPizzaGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder(); // 15.00
        theOrder = new ExtraCheesePizzaDecorator(theOrder); // + 2.00
        theOrder = new OlivesPizzaDecorator(theOrder); // +0.85
        theOrder = new PepperoniPizzaDecorator(theOrder); // +5.20
        theOrder = new PepperoniPizzaDecorator(theOrder); // +5.20
        theOrder = new JalapenoPizzaDecorator(theOrder); // +2.50

        //When
        BigDecimal cost = theOrder.getCost().setScale(2, BigDecimal.ROUND_HALF_EVEN);

        //Then
        Assert.assertEquals(new BigDecimal(30.75), cost);
    }

    @Test
    public void testCreatingFancyPizzaGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheesePizzaDecorator(theOrder);
        theOrder = new OlivesPizzaDecorator(theOrder);
        theOrder = new PepperoniPizzaDecorator(theOrder);
        theOrder = new PepperoniPizzaDecorator(theOrder);
        theOrder = new JalapenoPizzaDecorator(theOrder);

        //When
        String ingredients = theOrder.getIngredients();
        String expectedIngredients = "Ingredients: base, tomato sauce, cheese, extra cheese, olives, pepperoni, pepperoni, jalapeno";

        //Then
        Assert.assertEquals(expectedIngredients, ingredients);
    }
}
