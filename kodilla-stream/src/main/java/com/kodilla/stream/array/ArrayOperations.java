package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {
    static double getAverage(int[] numbers){ // method from the task
        IntStream.range(0,numbers.length)
                .forEach(n -> System.out.println(numbers[n]));

        return IntStream.range(0, numbers.length)
                .map(n->numbers[n])
                .average().getAsDouble();
    }

    static double getAverage2(int[] numbers){ // additional way
        IntStream.range(0,numbers.length)
                .forEach(n -> System.out.println(numbers[n]));

        return IntStream.of(numbers)
                .average().getAsDouble();
    }
}
