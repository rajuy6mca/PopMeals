package com.ppm.cs.warmup;

import java.util.Arrays;

/**
 * Counts words in a given string (camel case).
 */
public class CountWords {

    public static void main(String[] args) {

        String input = "thisContainsFourWords";

        System.out.printf("Number of words in input %s are %d%n", input, countWords(input));

    }

    public static long countWords(String input) {
        // Empty string ?
        if ((input == null) || (input.length() <= 0)) {
            return 0;
        }
        return input.chars().filter(code -> Character.isUpperCase(code)).count() + 1;
    }
}

