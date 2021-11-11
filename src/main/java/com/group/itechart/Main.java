package com.group.itechart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dmitry.matrizaev
 */

public class Main {

    public static void main(String[] args) {

        SimpleFizzerBuzzer fizzerBuzzer = new SimpleFizzerBuzzer();
        System.out.println(fizzerBuzzer.doFizzAndBuzzFromRange(1, 100));

        Map<Integer, String> inputMap = new HashMap<>();
        inputMap.put(5, "Fuzz");
        inputMap.put(4, "Buzz");
        inputMap.put(2, "Fizz");
        System.out.println(fizzerBuzzer.doFizzAndBuzzFromMapAndRange(inputMap, 1, 100));
    }
}
