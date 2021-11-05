package com.amppoul.katafizzbuzz;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzzApp {

    public static void main(String[] args) {
        final FizzBuzzApp app = new FizzBuzzApp();
        final var result = IntStream.rangeClosed(1, 100)
                .mapToObj(number -> app.convert(number) + "\n")
                .collect(Collectors.joining());
        System.out.println(result);
    }

    public String convert(int number) {

        final StringBuilder result = new StringBuilder();
        final String numberStr = String.valueOf(number);

        if (containingOrDivisibleBy3(number) ||
                containingOrDivisibleBy5(number)) {

            if (isDivisibleBy5(number) && isDivisibleBy3(number)) {
                result.append("FizzBuzz");
            }
            else if (isDivisibleBy3(number)) {
                result.append("Fizz");
            }
            else if (isDivisibleBy5(number)) {
                result.append("Buzz");
            }
            result.append(convertNumberContaining3Or5(numberStr));
        }
        else {
            result.append(numberStr);
        }
        return result.toString();
    }

    private String convertNumberContaining3Or5(String numberStr) {
        final var result = new StringBuilder();
        for (int i = 0; i < numberStr.length(); i++) {
            final int value = Character.getNumericValue(numberStr.charAt(i));
            final var valueString = String.valueOf(value);

            if (containsNumber5(valueString)) {
                result.append("Buzz");
            }

            if (containsNumber3(valueString)) {
                result.append("Fizz");
            }
        }
        return result.toString();
    }

    private boolean containingOrDivisibleBy5(int number) {
        return containsNumber5(String.valueOf(number)) || isDivisibleBy5(number);
    }

    private boolean containingOrDivisibleBy3(int number) {
        return containsNumber3(String.valueOf(number)) || isDivisibleBy3(number);
    }

    private boolean containsNumber3(String value) {
        return value.contains("3");
    }

    private boolean isDivisibleBy3(int number) {
        return number % 3 == 0;
    }

    private boolean containsNumber5(String value) {
        return value.contains("5");
    }

    private boolean isDivisibleBy5(int number) {
        return number % 5 == 0;
    }
}
