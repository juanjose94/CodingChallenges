package org.example.hackerrank.basic;

import java.util.List;

public class MinMaxSum {

    public static void main(String[] args) {

        //TODO: Find the max and min possible summation in a List of integers

        List<Integer> arr = List.of(1,2,3,4,5);

        Integer minValue = minValue(arr);
        Integer maxValue = maxValue(arr);

        List.of(minValue,maxValue).forEach(System.out::println);
    }

    private static int minValue(List<Integer> arr){

        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < arr.size(); i++) {
            int tempValue = 0;
            for (int j = 0; j < arr.size(); j++) {
                if (i != j) {
                    tempValue = tempValue + arr.get(j);
                }
            }
            if (tempValue < minValue){
                minValue = tempValue;
            }
        }

        return minValue;
    }
    private static int maxValue(List<Integer> arr){
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < arr.size(); i++) {
            int tempValue = 0;
            for (int j = 0; j < arr.size(); j++) {
                if (i != j) {
                    tempValue = tempValue + arr.get(j);
                }
            }
            if (tempValue > maxValue){
                maxValue = tempValue;
            }
        }

        return maxValue;
    }
}
