package com.kodilla.stream.array;

import org.junit.Test;
import org.junit.Assert;

public class ArrayOperationsTestSuite {
    int[] numbers = {1,3,4,2};

    @Test
    public void testGetAverage(){
        //When
        double expected = 2.5;
        double real = ArrayOperations.getAverage(numbers);
        //Then
        Assert.assertEquals(expected, real, 0);
    }

    @Test
    public void testGetAverage2(){
        //When
        double expected = 2.5;
        double real = ArrayOperations.getAverage2(numbers);
        //Then
        Assert.assertEquals(expected, real, 0);
    }

}
