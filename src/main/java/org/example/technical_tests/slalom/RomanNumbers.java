package org.example.technical_tests.slalom;

import java.util.Map;

public class RomanNumbers {


    //TODO: given a string normal number, convert it to roman number.

    private static final int[] VALUES = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4, 1
    };

    private static final String[] SYMBOLS = {
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV", "I"
    };

    public static void main(String[] args) {

        String input = "251";

        System.out.println("Roman number for " + input + " is: " + convertToRoman(input));
    }

    private static String convertToRoman(String input) {

        // 1. Validate the input is a number.
        // 2. Convert the number to roman number.
        // 3. Return the result.
        StringBuilder result = new StringBuilder();

        int number = parseInput(input);

        for (int i = 0; i < VALUES.length; i++) {
            while (number >= VALUES[i]) {
                number -= VALUES[i];
                result.append(SYMBOLS[i]);
            }
        }

        return result.toString();
    }

    private static int parseInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input is not a valid number");
        }
    }
}