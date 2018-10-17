package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;


public class StreamMain {
    public static void main(String[] args) {

        /*PoemBeautifier exampleBeautifier = new PoemBeautifier();
        exampleBeautifier.PoemBeautifier("abcd", text -> text.toUpperCase());
        exampleBeautifier.PoemBeautifier("abcd", text -> text + " efgh");
        exampleBeautifier.PoemBeautifier("abcd", text -> text.substring(0,2));
        exampleBeautifier.PoemBeautifier("abcd", text -> "~~"+text+"~~"); */

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);


    }
}
