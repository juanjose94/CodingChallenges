package org.example.hackerrank.basic;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountingSort {

    public static void main(String[] args) {

        //TODO: return an Array counting the frequency of values inside of a given List.

        List<Integer> arr = new ArrayList<>(Arrays.asList(1,1,3,2,1));

        int maxSize = arr.stream().mapToInt(Integer::intValue).max().getAsInt();

        List<Integer> frequencyArray = getFrequencyArray(maxSize + 1);

        countingSort(arr, frequencyArray).forEach(System.out::println);
    }

    public static List<Integer> countingSort(List<Integer> arr, List<Integer> frequencyArray) {
        // Write your code here
        for (Integer integer : arr) {
            for (int j = 0; j < frequencyArray.size(); j++) {
                if (integer == j) {
                    frequencyArray.set(j, frequencyArray.get(j) + 1);
                }
            }
        }
        return frequencyArray;
    }

    public static List<Integer> getFrequencyArray(Integer size) {
        return Stream.generate(() -> 0).limit(size).collect(Collectors.toList());
    }
}
