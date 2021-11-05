package com.amppoul.katafizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzAppTest {

    private final FizzBuzzApp underTest = new FizzBuzzApp();

    @Test
    public void itShouldReturnsValueIfNotDivisibleBy3Or5() {

        String result = underTest.convert(1);
        assertEquals("1", result);

        result = underTest.convert(2);
        assertEquals("2", result);

        result = underTest.convert(4);
        assertEquals("4", result);

        result = underTest.convert(7);
        assertEquals("7", result);

        result = underTest.convert(14);
        assertEquals("14", result);
    }

    @Test
    public void itShouldReturnsFizzFizzWhenNumberEquals3() {
        final var result = underTest.convert(3);
        assertEquals("FizzFizz", result);
    }

    @Test
    public void itShouldReturnsFizzFizzFizzWhenNumberEquals33() {
        final var result = underTest.convert(33);
        assertEquals("FizzFizzFizz", result);
    }

    @Test
    public void itShouldReturnsFizzWhenNumberEquals13() {
        final var result = underTest.convert(13);
        assertEquals("Fizz", result);
    }

    @Test
    public void itShouldReturnsFizzWhenNumberIsDivisibleBy3() {
        var result = underTest.convert(6);
        assertEquals("Fizz", result);

        result = underTest.convert(9);
        assertEquals("Fizz", result);

        result = underTest.convert(12);
        assertEquals("Fizz", result);
    }

    @Test
    public void itShouldReturnsBuzzBuzzWhenNumberDivisibleAndContains5() {
        var result = underTest.convert(5);
        assertEquals("BuzzBuzz", result);
    }

    @Test
    public void itShouldReturnsBuzzBuzzWhenNumberDivisibleByAndContains5AndContains3() {
        var result = underTest.convert(35);
        assertEquals("BuzzFizzBuzz", result);
    }

    @Test
    public void itShouldReturnsBuzzWhenNumberIsDivisibleBy5() {
        var result = underTest.convert(10);
        assertEquals("Buzz", result);

        result = underTest.convert(20);
        assertEquals("Buzz", result);
    }

    @Test
    public void itShouldReturnsFizzBuzzBuzzWhenNumberIsDivisibleBy15AndContaining5() {
        var result = underTest.convert(15);
        assertEquals("FizzBuzzBuzz", result);
    }

    @Test
    public void itShouldReturnsFizzBuzzFizzWhenNumberIsDivisibleBy15AndContaining3() {
        var result = underTest.convert(30);
        assertEquals("FizzBuzzFizz", result);
    }

    @Test
    public void itShouldReturnsBuzzFizzWhenNumberEquals53() {
        var result = underTest.convert(53);
        assertEquals("BuzzFizz", result);
    }
}