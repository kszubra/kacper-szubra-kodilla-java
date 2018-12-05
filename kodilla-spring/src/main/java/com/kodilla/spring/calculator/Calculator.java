package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

    @Autowired
    private Display display;

    public double add(double a, double b) {
        display.displayValue(a+b);
        return a+b;
    }

    public double sub(double a, double b) {
        display.displayValue(a-b);
        return a-b;
    }

    public double div(double a, double b) {
        try {
            display.displayValue(a/b);
            return a/b;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            return Double.POSITIVE_INFINITY;
        }
    }

    public double mul(double a, double b) {
        display.displayValue(a*b);
        return a*b;
    }
}
