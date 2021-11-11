import com.group.itechart.SimpleFizzerBuzzer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author dmitry.matrizaev
 */

class SimpleFizzerBuzzerTest {

    private SimpleFizzerBuzzer fizzerBuzzer;

    @BeforeEach
    void setup() {
        fizzerBuzzer = new SimpleFizzerBuzzer();
    }

    @Test
    void whenCallDoFizzAndBuzzFromRangeWithCorrectInputThenReturnOutput() {
        String result = "1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz Fizz 22 23 Fizz Buzz 26 Fizz 28 29 FizzBuzz 31 32 Fizz 34 Buzz Fizz 37 38 Fizz Buzz 41 Fizz 43 44 FizzBuzz 46 47 Fizz 49 Buzz Fizz 52 53 Fizz Buzz 56 Fizz 58 59 FizzBuzz 61 62 Fizz 64 Buzz Fizz 67 68 Fizz Buzz 71 Fizz 73 74 FizzBuzz 76 77 Fizz 79 Buzz Fizz 82 83 Fizz Buzz 86 Fizz 88 89 FizzBuzz 91 92 Fizz 94 Buzz Fizz 97 98 Fizz Buzz ";
        assertEquals(fizzerBuzzer.doFizzAndBuzzFromRange(1, 100), result);
    }

    @Test
    void whenCallDoFizzAndBuzzFromMapAndRangeWithThreeAndFiveThenReturnOutput() {
        String result = "1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz Fizz 22 23 Fizz Buzz 26 Fizz 28 29 FizzBuzz 31 32 Fizz 34 Buzz Fizz 37 38 Fizz Buzz 41 Fizz 43 44 FizzBuzz 46 47 Fizz 49 Buzz Fizz 52 53 Fizz Buzz 56 Fizz 58 59 FizzBuzz 61 62 Fizz 64 Buzz Fizz 67 68 Fizz Buzz 71 Fizz 73 74 FizzBuzz 76 77 Fizz 79 Buzz Fizz 82 83 Fizz Buzz 86 Fizz 88 89 FizzBuzz 91 92 Fizz 94 Buzz Fizz 97 98 Fizz Buzz ";
        Map<Integer, String> map = new HashMap<>();
        map.put(3, "Fizz");
        map.put(5, "Buzz");
        assertEquals(fizzerBuzzer.doFizzAndBuzzFromMapAndRange(map, 1, 100), result);
    }

    @Test
    void whenCallDoFizzAndBuzzFromMapAndRangeWithRevertedRangeThenReturnEmptyString() {
        String result = "";
        Map<Integer, String> map = new HashMap<>();
        map.put(3, "Fizz");
        map.put(5, "Buzz");
        assertEquals(fizzerBuzzer.doFizzAndBuzzFromMapAndRange(map, 100, 1), result);
        assertEquals(fizzerBuzzer.doFizzAndBuzzFromMapAndRange(map, 10, 0), result);
    }

    @Test
    void whenCallDoFizzAndBuzzFromMapAndRangeWithNegativesInRangeThenReturnEmptyString() {
        String result = "";
        Map<Integer, String> map = new HashMap<>();
        map.put(3, "Fizz");
        map.put(5, "Buzz");
        assertEquals(fizzerBuzzer.doFizzAndBuzzFromMapAndRange(map, -5, 10), result);
        assertEquals(fizzerBuzzer.doFizzAndBuzzFromMapAndRange(map, -5, -10), result);
    }

    @Test
    void whenCallDoFizzAndBuzzFromMapAndRangeWithNegativesInMapThenReturnEmptyString() {
        String result = "";
        Map<Integer, String> map = new HashMap<>();
        map.put(-3, "Fizz");
        map.put(-5, "Buzz");
        assertEquals(fizzerBuzzer.doFizzAndBuzzFromMapAndRange(map, 1, 100), result);
    }

    @Test
    void whenCallDoFizzAndBuzzFromMapAndRangeWithEmptyValuesInMapThenReturnEmptyString() {
        String result = "";
        Map<Integer, String> map = new HashMap<>();
        map.put(3, "");
        map.put(5, "Buzz");
        assertEquals(fizzerBuzzer.doFizzAndBuzzFromMapAndRange(map, 1, 100), result);
    }

    @Test
    void whenCallDoFizzAndBuzzFromMapAndRangeWithTwoAndFourAndFiveThenReturnOutput() {
        String result = "1 Fizz 3 FizzBuzz Fuzz Fizz 7 FizzBuzz 9 FizzFuzz 11 FizzBuzz 13 Fizz Fuzz FizzBuzz 17 Fizz 19 FizzBuzzFuzz 21 Fizz 23 FizzBuzz Fuzz Fizz 27 FizzBuzz 29 FizzFuzz 31 FizzBuzz 33 Fizz Fuzz FizzBuzz 37 Fizz 39 FizzBuzzFuzz 41 Fizz 43 FizzBuzz Fuzz Fizz 47 FizzBuzz 49 FizzFuzz 51 FizzBuzz 53 Fizz Fuzz FizzBuzz 57 Fizz 59 FizzBuzzFuzz 61 Fizz 63 FizzBuzz Fuzz Fizz 67 FizzBuzz 69 FizzFuzz 71 FizzBuzz 73 Fizz Fuzz FizzBuzz 77 Fizz 79 FizzBuzzFuzz 81 Fizz 83 FizzBuzz Fuzz Fizz 87 FizzBuzz 89 FizzFuzz 91 FizzBuzz 93 Fizz Fuzz FizzBuzz 97 Fizz 99 FizzBuzzFuzz ";
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "Fizz");
        map.put(4, "Buzz");
        map.put(5, "Fuzz");
        assertEquals(fizzerBuzzer.doFizzAndBuzzFromMapAndRange(map, 1, 100), result);
    }

}
