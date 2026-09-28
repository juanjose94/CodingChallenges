package org.example.proof_of_concepts;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main_Stream_2 {

    public static void main(String[] args) {

        List<String> someStringNumberList = List.of("2","1","4","5","3");
        List<String> someStringLetterList = List.of("z","h","b","a","b");
        List<Integer> someDivisibleNumber = List.of(2,4,9,3,15,20,8,21);


        List<String> filteredSomeStringNumberList = someStringNumberList.stream().filter( number -> number.equals("2")).sorted().toList();
        List<String> filteredSomeStringNumberListSorted = someStringNumberList.stream().sorted(Comparator.reverseOrder()).toList();
        Long someDivisibleNumberMax = someDivisibleNumber.stream().map(number -> number * 3).filter(number -> number % 3 == 0).count();

        filteredSomeStringNumberListSorted.forEach(System.out::println);
        //System.out.println(someDivisibleNumberMax);
    }
}
