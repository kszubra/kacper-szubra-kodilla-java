package com.kodillapatterns2.decorator.taxiportal;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class TaxiOrderTestSuite {

    @Test
    public void testBAsicTaxiOrderGetCost() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        //When
        BigDecimal cost = theOrder.getCost();
        //Then
        Assert.assertEquals(new BigDecimal(5.00), cost);
    }

    @Test
    public void testTaxiNetworkGetCost() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder(); // Najpierw tworzony jest delegat
        theOrder = new TaxiNetworkOrderDecorator(theOrder); // następnie tworzony jest dekorator (i przypisywany do tej samej zmiennej co wcześniej delegat)

        //When
        BigDecimal cost = theOrder.getCost();

        //Then
        Assert.assertEquals(new BigDecimal(40.00), cost);
    }

    @Test
    public void testUberWithChildSeat() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new UberNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        //When
        BigDecimal cost = theOrder.getCost();
        String description = theOrder.getDescription();

        //Then
        Assert.assertEquals(new BigDecimal(27.00), cost);
        Assert.assertEquals("Drive a course by Uber + child seat", description);

    }
}
