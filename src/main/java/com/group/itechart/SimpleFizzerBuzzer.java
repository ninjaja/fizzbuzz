package com.group.itechart;


import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author dmitry.matrizaev
 */

public class SimpleFizzerBuzzer {

    public static final Logger LOGGER = LogManager.getLogger(SimpleFizzerBuzzer.class);

    /**
     * Method that receives a range of integers and returns a String filled with 'Fizz' in case of number in the given
     * range is divisible by 3, 'Buzz' - in case of 5, 'FizzBuzz' - if divisible by both and a number itself in case it
     * is divisible by neither.
     *
     * @param from range starting number (inclusive)
     * @param to   range ending number (inclusive)
     * @return string filled according to the description above
     */
    public String doFizzAndBuzzFromRange(int from, int to) {
        StringBuilder result = new StringBuilder();
        if (validateInputRange(from, to)) {
            for (int i = from; i <= to; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    result.append("FizzBuzz");
                } else if (i % 3 == 0) {
                    result.append("Fizz");
                } else if (i % 5 == 0) {
                    result.append("Buzz");
                } else {
                    result.append(i);
                }
                result.append(" ");
            }
        }
        return result.toString();
    }

    /**
     * Method that receives a {@code Map<Integer, String>} and a range of integers and returns a String filled with
     * map's values in case of number in the given range is divisible by map's key. Map is internally sorted by
     * {@code Integer} values for output consistency. In case a number in the range is
     * divisible by several keys, values are concatenated.
     *
     * @param inputMap Map containing pairs of integers and Strings
     * @param from     range starting number (inclusive)
     * @param to       range ending number (inclusive)
     * @return string filled according to the description above
     */
    public String doFizzAndBuzzFromMapAndRange(Map<Integer, String> inputMap, int from, int to) {
        StringBuilder result = new StringBuilder();
        if (validateInputRange(from, to) && validateInputMap(inputMap)) {
            Map<Integer, String> sortedMap = getSortedInputMap(inputMap);

            IntStream.range(from, ++to).forEach(index -> {
                StringBuilder valueToAppend = new StringBuilder();
                sortedMap.forEach((key, value) -> {
                    if (index % key == 0) {
                        valueToAppend.append(value);
                    }
                });
                if (StringUtils.isEmpty(valueToAppend)) {
                    valueToAppend.append(index);
                }
                result.append(valueToAppend).append(" ");
            });
        }
        return result.toString();
    }

    /**
     * Method for sorting an input {@code Map<Integer, String>} by keys.
     *
     * @param inputMap unsorted input Map
     * @return sorted Map
     */
    private Map<Integer, String> getSortedInputMap(Map<Integer, String> inputMap) {
        return inputMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    /**
     * Method for validating the input range.
     *
     * @param from range starting number (inclusive)
     * @param to   range ending number (inclusive)
     * @return boolean value of whether the range has passed the validation
     */
    private boolean validateInputRange(int from, int to) {
        boolean isInputValid;
        if (from >= 0 && to >= 0 && from < to) {
            isInputValid = true;
        } else {
            LOGGER.warn("Please enter correct input range values");
            isInputValid = false;
        }
        return isInputValid;
    }

    /**
     * Method for validating the input map.
     *
     * @param map input map
     * @return boolean value of whether the map has passed the validation
     */
    private boolean validateInputMap(Map<Integer, String> map) {
        boolean isMapValid = true;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() < 0) {
                LOGGER.warn("Input map keys should be more than 0");
                isMapValid = false;
            }
            if (StringUtils.isEmpty(entry.getValue())) {
                LOGGER.warn("Input map values should not be empty or null");
                isMapValid = false;
            }
        }
        return isMapValid;
    }
}
