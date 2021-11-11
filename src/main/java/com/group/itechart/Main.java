package com.group.itechart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dmitry.matrizaev
 */

public class Main {

    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {


        SimpleFizzerBuzzer fizzerBuzzer = new SimpleFizzerBuzzer();
        System.out.println(fizzerBuzzer.doFizzAndBuzzFromRange(1, 100));

        Map<Integer, String> inputMap = new HashMap<>();
        inputMap.put(3, "Fizz");
        inputMap.put(5, "Buzz");
        System.out.println(fizzerBuzzer.doFizzAndBuzzFromMapAndRange(inputMap, 1, 100));
    }
}
