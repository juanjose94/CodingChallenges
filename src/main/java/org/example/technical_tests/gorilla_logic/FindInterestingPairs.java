package org.example.technical_tests.gorilla_logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindInterestingPairs {

    public static void main(String[] args) {

        // TODO: Complexity:
        // Time: O(n) (single pass + small extra loop over map).
        // Space: O(n) for frequency map.

        List<Integer> input = List.of(1,3,2,0);

        System.out.println("solution: " + findInterestingPairs(input, 2));

    }

    public static long findInterestingPairs(List<Integer> arr, int sumVal) {
        // Write your code here
        //1. Identify the interesting pairs
        //2. Identify the moment when the absolute value is less than the elements of the array maybe?
        //2a. case one: the abs value is equal than the array element.
        //2b. case two: the abs value is less than the array element.
        //3. Calculate all absolute value.
        //4. Do the sum in the pairs
        //5. gather the sum results and identify which two sums are the same (interesting pair)


        // If sumVal is odd, no valid pairs
        if (sumVal % 2 != 0) return 0;
        int target = sumVal / 2;

        // Count frequencies of absolute values
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            int abs = Math.abs(num);
            freq.put(abs, freq.getOrDefault(abs, 0) + 1);
        }

        int countTarget = freq.getOrDefault(target, 0);
        if (countTarget == 0) return 0;

        // Count all elements with abs <= target
        long countLessOrEqual = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getKey() <= target) {
                countLessOrEqual += entry.getValue();
            }
        }

        // Combinatorial count
        long pairs = 0;
        // Case 1: both are target
        pairs += (long) countTarget * (countTarget - 1) / 2;
        // Case 2: one is target, the other less than target
        pairs += (long) countTarget * (countLessOrEqual - countTarget);

        return pairs;
    }
}


