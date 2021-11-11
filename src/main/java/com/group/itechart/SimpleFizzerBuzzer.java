package com.group.itechart;


import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.Objects;

/**
 * @author dmitry.matrizaev
 */

public class SimpleFizzerBuzzer {

    public static final Logger LOGGER = LogManager.getLogger(SimpleFizzerBuzzer.class);

    public StringBuilder doFizzAndBuzzFromRange(int from, int to) {
        StringBuilder result = new StringBuilder();
        if (validateInputRange(from, to)) {
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
        }
        return result;
    }

    public StringBuilder doFizzAndBuzzFromMapAndRange(Map<Integer, String> inputMap, int from, int to) {
        StringBuilder result = new StringBuilder();
        if (validateInputRange(from, to) && validateInputMap(inputMap)) {
            for (int i = from; i <= to; i++) {
                String valueToAppend = null;
                for (Map.Entry<Integer, String> entry : inputMap.entrySet()) {
                    if (i % entry.getKey() == 0) {
                        valueToAppend = entry.getValue();
                    }
                }
                if (Objects.isNull(valueToAppend)) {
                    valueToAppend = String.valueOf(i);
                }
                result.append(valueToAppend).append(" ");
            }
        }
        return result;
    }

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
