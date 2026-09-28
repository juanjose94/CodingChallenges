package org.example.technical_tests.slalom;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class FlatNestedStructure {

    public static void main(String[] args) {
        //TODO: You are given a nested structure represented as a List<Object> where each element can be either an Integer
        // or another List<Object> (nested to any depth).
        //
        //Write a method that flattens the structure into a single List<Integer> containing all values in their original
        //left-to-right order.

        //Example Input:
        //[1, [2, 3], [4, [5, 6]], 7]
        //Expected Output:
        //[1, 2, 3, 4, 5, 6, 7]

        List<Object> input = List.of(1,List.of(2,3),List.of(4,List.of(5,6),7));

        flatList(input).forEach(System.out::println);


        // Complexity:
        // Time: O(n)
        // Space: O(d)
        // Cyclomatic: 4 (1 for flatList() method call, 1 for flatten() method call, + 2 for flatten() method ifs)
        // Total space: O(n+d)
    }

    private static List<Integer> flatList(List<Object> input) {

        // 1. Identify which elements are other lists.
        // 2. Flat them, need recursive
        // 2a. if there is any list elements inside, call my recursive method instead
        // 2b. if not, flat them
        // 3. Gather the result into  Integer list

        return input.stream()
                .flatMap(FlatNestedStructure::flatten)
                .toList();
    }


    public static Stream<Integer> flatten(Object element) {
        if (element instanceof Integer i) {
            return Stream.of(i);
        }

        if (element instanceof List<?> list) {
            return list.stream()
                    .flatMap(FlatNestedStructure::flatten);
        }

        return Stream.empty();
    }
}
