package org.example.technical_tests.slalom;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SortNameLists {

    public SortNameLists() {
    }

    public static void main(String[] args) {


        //TODO: Problem Statement:
        //
        //Given an array of strings representing a list of names,
        // write a method that returns the list sorted by the last character of each string.
        // If two strings share the same last character, sort those strings alphabetically among themselves.
        //Example Input:
        //
        //["Carlos", "Andrea", "Bob", "Amanda", "Greg", "Steve"]
        //
        //Expected Output:
        //
        //["Amanda", "Andrea", "Steve", "Bob", "Greg", "Carlos"]
        //(a, a, e, b, g, s — sorted by last char, ties broken alphabetically)

        // List<String> input = List.of("Carlos", "Andrea", "Bob", "Amanda", "Greg", "Steve");
        List<String> input = List.of(
                "Carlos",
                "Andrea",
                "Bob",
                "Amanda",
                "Greg",
                "Steve",
                "Alice"
        );
        //List<String> input = List.of();
        sortInputList(input).forEach(System.out::println);
    }

    private static List<String> sortInputList(List<String> input) {

        //1 Iterate over the string
        //2 convert last element string into char.
        //2a If tie, compare with the name
        //3 Sort using the last element of char
        //4 Gather the result in a new list
        //5 check validations?

        return isInputEmpty(input) ? Collections.emptyList() : input.stream()
                .sorted(Comparator.comparing( (String name) -> name.charAt(name.length() - 1))
                        .thenComparing(String::compareTo))
                .collect(Collectors.toList());
    }

    private static boolean isInputEmpty(List<String> input) {
        return Objects.isNull(input) || input.isEmpty();
    }
}
