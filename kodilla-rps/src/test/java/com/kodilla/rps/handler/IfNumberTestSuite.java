package com.kodilla.rps.handler;

import org.junit.Assert;
import org.junit.Test;

public class IfNumberTestSuite {

    @Test
    public void testIfNumber(){
        //Given
        String notIntNumber = "32sadasdfe";
        String notIntNumber2 = "12.4";
        String intNumber = "12";
        //Then
        Assert.assertEquals(true, IfNumber.isItInteger(intNumber));
        Assert.assertEquals(false, IfNumber.isItInteger(notIntNumber));
        Assert.assertEquals(false, IfNumber.isItInteger(notIntNumber2));
    }

}
