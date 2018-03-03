package com.kodilla.stream.array;

import java.util.stream.IntStream;

public class AverageArrayCount implements ArrayOperations {

    public int getTableValue(int[] numbers, int rows) {
        return numbers[rows];
    }

    @Override
    public double getAverage(int[] numbers) {
        IntStream.range(0, numbers.length)
                .mapToDouble(n -> numbers[n])
                .forEach(System.out::println);

        return IntStream.range(0, numbers.length)
                .mapToDouble(n -> numbers[n])
                .average()
                .orElse(0.0);
    }
}
