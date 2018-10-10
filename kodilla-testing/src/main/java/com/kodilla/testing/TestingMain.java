package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args){

        System.out.println("----First unit test----");
        double result = Calculator.add(3, 7);
        if(result == 10){
            System.out.println("Add test OK");
        } else {
            System.out.println("Add test FAILED");
        }

        System.out.println("----Second unit test----");
        result = Calculator.substract(11, 3);
        if(result == 8){
            System.out.println("Substract test OK");
        } else {
            System.out.println("Substract test FAILED");
        }


    }
}
