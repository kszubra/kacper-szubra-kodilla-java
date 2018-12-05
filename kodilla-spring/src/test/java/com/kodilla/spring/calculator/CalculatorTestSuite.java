package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {

    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator testCalculator = context.getBean(Calculator.class);

        double a = 10.0;
        double b = 2.0;

        //When
        double expectedAdd = 12.0;
        double realAdd = testCalculator.add(a, b);

        double expectedSub = 8.0;
        double realSub = testCalculator.sub(a, b);

        double expectedDiv = 5.0;
        double realDiv = testCalculator.div(a, b);

        double expectedMul = 20.0;
        double realMul = testCalculator.mul(a, b);

        //Then
        Assert.assertEquals(expectedAdd, realAdd, 0.001);
        Assert.assertEquals(expectedSub, realSub, 0.001);
        Assert.assertEquals(expectedDiv, realDiv, 0.001);
        Assert.assertEquals(expectedMul, realMul, 0.001);
    }
}
