package com.amppoul.katafizzbuzz;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzzApp {

    public static void main(String[] args) {
        final FizzBuzzApp app = new FizzBuzzApp();
        final var result = IntStream.rangeClosed(1, 100)
                .mapToObj(number -> app.convert(number) + "\n")
                .collect(Collectors.joining());

        System.out.println("Print numbers from 1 to 100:");
        System.out.println(result);
    }

    public String convert(int number) {
        final String numberStr = String.valueOf(number);

        if (!isConvertible(number)) {
            return numberStr;
        }

        final StringBuilder result = new StringBuilder();
        if (isDivisibleBy3And5(number)) {
            addFizzBuzz(result);
        } else if (isDivisibleBy3(number)) {
            addFizz(result);
        } else if (isDivisibleBy5(number)) {
            addBuzz(result);
        }
        appendTo(result, convertNumberContaining3Or5(numberStr));
        return result.toString();
    }

    private boolean isConvertible(int number) {
        return isContainingOrDivisibleBy3(number) ||
                isContainingOrDivisibleBy5(number);
    }

    private String convertNumberContaining3Or5(String number) {
        final var result = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            final int value = Character.getNumericValue(number.charAt(i));
            final var valueString = String.valueOf(value);

            if (itContainsNumber3(valueString)) {
                addFizz(result);
            }

            if (itContainsNumber5(valueString)) {
                addBuzz(result);
            }
        }
        return result.toString();
    }

    private void addFizzBuzz(StringBuilder result) {
        appendTo(result, "FizzBuzz");
    }

    private void addFizz(StringBuilder result) {
        appendTo(result, "Fizz");
    }

    private void addBuzz(StringBuilder result) {
        appendTo(result, "Buzz");
    }

    private void appendTo(StringBuilder result, String content) {
        result.append(content);
    }

    private boolean isContainingOrDivisibleBy5(int number) {
        return itContainsNumber5(String.valueOf(number)) || isDivisibleBy5(number);
    }

    private boolean isContainingOrDivisibleBy3(int number) {
        return itContainsNumber3(String.valueOf(number)) || isDivisibleBy3(number);
    }

    private boolean itContainsNumber3(String value) {
        return value.contains("3");
    }

    private boolean isDivisibleBy3(int number) {
        return number % 3 == 0;
    }

    private boolean itContainsNumber5(String value) {
        return value.contains("5");
    }

    private boolean isDivisibleBy5(int number) {
        return number % 5 == 0;
    }

    private boolean isDivisibleBy3And5(int number) {
        return isDivisibleBy5(number) && isDivisibleBy3(number);
    }
}
