package com.group.itechart;

/**
 * @author dmitry.matrizaev
 */

public class SimpleFizzerBuzzer {

    public StringBuilder doBuzzAndFuzz(int from, int to) {
        StringBuilder result = new StringBuilder();
        for (int i = from; i <= to; i++) {
            if (i % 3 == 0) {
                result.append("Fizz");
            } else if (i % 5 == 0) {
                result.append("Buzz");
            } else {
                result.append(i);
            }
            result.append(" ");
        }
        return result;
    }
}
