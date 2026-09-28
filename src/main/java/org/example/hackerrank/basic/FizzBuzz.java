package org.example.hackerrank.basic;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {

    public static void main(String[] args) {

        //TODO: Create a n-elements array with sequential numbers, then replace the following numbers depending of:
        // Numbers that are multiples of 3 with Fizz
        // Numbers that are multiples of 5 with Buzz
        // Numbers that are multiples of 3 and 5 with FizzBuzz

        fizzBuzz(15);
    }

    public static void fizzBuzz(int n) {
        // Write your code here
        List<Integer> integerList = IntStream.rangeClosed(1, n)
                .boxed()
                .collect(Collectors.toList());

        integerList.stream()
                .map(number -> isMultiple(number))
                .forEach(System.out::println);
    }

    public static String isMultiple(Integer number){
        boolean multipleOfThree = number % 3 == 0;
        boolean multipleOfFive= number % 5 == 0;
        if (multipleOfThree && multipleOfFive){
            return "FizzBuzz";
        }else if (multipleOfThree){
            return "Fizz";
        }else if (multipleOfFive){
            return "Buzz";
        }
        return String.valueOf(number);
    }
}
