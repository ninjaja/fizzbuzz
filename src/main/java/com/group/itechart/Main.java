package com.group.itechart;

/**
 * @author dmitry.matrizaev
 */

public class Main {

    public static void main(String[] args) {
        SimpleFizzerBuzzer fizzerBuzzer = new SimpleFizzerBuzzer();
        System.out.println(fizzerBuzzer.doBuzzAndFuzz(1, 100));
    }
}
