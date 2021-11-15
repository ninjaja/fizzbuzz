package com.group.itechart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author dmitry.matrizaev
 */

class SimpleFizzerBuzzerTest {

    private SimpleFizzerBuzzer fizzerBuzzer;
    private final Map<Integer, String> fizzBuzzInputMap = Map.of(3, "Fizz", 5, "Buzz");
    private static final String FIZZ_BUZZ_OUTPUT = "1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz Fizz 22 23 Fizz Buzz 26 Fizz 28 29 FizzBuzz 31 32 Fizz 34 Buzz Fizz 37 38 Fizz Buzz 41 Fizz 43 44 FizzBuzz 46 47 Fizz 49 Buzz Fizz 52 53 Fizz Buzz 56 Fizz 58 59 FizzBuzz 61 62 Fizz 64 Buzz Fizz 67 68 Fizz Buzz 71 Fizz 73 74 FizzBuzz 76 77 Fizz 79 Buzz Fizz 82 83 Fizz Buzz 86 Fizz 88 89 FizzBuzz 91 92 Fizz 94 Buzz Fizz 97 98 Fizz Buzz ";
    private static final String FIZZ_BUZZ_FUZZ_OUTPUT = "1 Fizz 3 FizzBuzz Fuzz Fizz 7 FizzBuzz 9 FizzFuzz 11 FizzBuzz 13 Fizz Fuzz FizzBuzz 17 Fizz 19 FizzBuzzFuzz 21 Fizz 23 FizzBuzz Fuzz Fizz 27 FizzBuzz 29 FizzFuzz 31 FizzBuzz 33 Fizz Fuzz FizzBuzz 37 Fizz 39 FizzBuzzFuzz 41 Fizz 43 FizzBuzz Fuzz Fizz 47 FizzBuzz 49 FizzFuzz 51 FizzBuzz 53 Fizz Fuzz FizzBuzz 57 Fizz 59 FizzBuzzFuzz 61 Fizz 63 FizzBuzz Fuzz Fizz 67 FizzBuzz 69 FizzFuzz 71 FizzBuzz 73 Fizz Fuzz FizzBuzz 77 Fizz 79 FizzBuzzFuzz 81 Fizz 83 FizzBuzz Fuzz Fizz 87 FizzBuzz 89 FizzFuzz 91 FizzBuzz 93 Fizz Fuzz FizzBuzz 97 Fizz 99 FizzBuzzFuzz ";
    private static final String EMPTY_STRING = "";

    @BeforeEach
    void setup() {
        fizzerBuzzer = new SimpleFizzerBuzzer();
    }

    @Test
    void whenCallDoFizzAndBuzzFromRangeWithCorrectInputThenReturnOutput() {
        assertEquals(FIZZ_BUZZ_OUTPUT, fizzerBuzzer.doFizzAndBuzzFromRange(1, 100));
    }

    @Test
    void whenCallDoFizzAndBuzzFromMapAndRangeWithThreeAndFiveThenReturnOutput() {
        assertEquals(FIZZ_BUZZ_OUTPUT, fizzerBuzzer.doFizzAndBuzzFromMapAndRange(fizzBuzzInputMap, 1, 100));
    }

    @Test
    void whenCallDoFizzAndBuzzFromMapAndRangeWithRevertedRangeThenReturnEmptyString() {
        assertEquals(EMPTY_STRING, fizzerBuzzer.doFizzAndBuzzFromMapAndRange(fizzBuzzInputMap, 100, 1));
        assertEquals(EMPTY_STRING, fizzerBuzzer.doFizzAndBuzzFromMapAndRange(fizzBuzzInputMap, 10, 0));
    }

    @Test
    void whenCallDoFizzAndBuzzFromMapAndRangeWithNegativesInRangeThenReturnEmptyString() {
        assertEquals(EMPTY_STRING, fizzerBuzzer.doFizzAndBuzzFromMapAndRange(fizzBuzzInputMap, -5, 10));
        assertEquals(EMPTY_STRING, fizzerBuzzer.doFizzAndBuzzFromMapAndRange(fizzBuzzInputMap, -5, -10));
    }

    @Test
    void whenCallDoFizzAndBuzzFromMapAndRangeWithNegativesInMapThenReturnEmptyString() {
        Map<Integer, String> map = Map.of(-3, "Fizz", -5, "Buzz");
        assertEquals(EMPTY_STRING, fizzerBuzzer.doFizzAndBuzzFromMapAndRange(map, 1, 100));
    }

    @Test
    void whenCallDoFizzAndBuzzFromMapAndRangeWithEmptyValuesInMapThenReturnEmptyString() {
        Map<Integer, String> map = Map.of(3, EMPTY_STRING, -5, "Buzz");
        assertEquals(EMPTY_STRING, fizzerBuzzer.doFizzAndBuzzFromMapAndRange(map, 1, 100));
    }

    @Test
    void whenCallDoFizzAndBuzzFromMapAndRangeWithTwoAndFourAndFiveThenReturnOutput() {
        Map<Integer, String> map = Map.of(2, "Fizz", 4, "Buzz", 5, "Fuzz");
        assertEquals(FIZZ_BUZZ_FUZZ_OUTPUT, fizzerBuzzer.doFizzAndBuzzFromMapAndRange(map, 1, 100));
    }

}
