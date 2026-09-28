package org.example.hackerrank.basic;

import java.util.List;

public class SimpleArraySum {

    public static void main(String[] args) {

        //TODO: Add all values in array

        List<Integer> array = List.of(1,2,3);

        System.out.println("The result is: " + arraySum(array));
    }

    private static int arraySum(List<Integer> array){
        return array.stream().mapToInt(Integer::intValue).sum();
    }
}
