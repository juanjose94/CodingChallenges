package org.example.technical_tests.gap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountingWords {

    //Write a function that counts the number of words in a string.
    //The words in the string are split by white spaces.
    //For example: "java language hi java language program" and the output is:
    //java 2
    //language 2
    //hi 1
    //program 1

    // 1. Separate each word -> Regular expression.
    // 2. Iterate over them -> For/ForEach
    // 2a. Identify the words to count them (How?)
    // 3. Count every encounter
    // 3a. if for/foreach -> counter variable,
    // 3b. Stream solution -> counter method.
    // 4. Return the result
    // 4a. for/foearch -> Return a Map<String, int>
    // 4b. Collector.CollectorTo -> Return a Map<String, int>
    // 5. print the result

    public static void main(String[] args) {

        String input = "java language hi java language program";

        Map<String, Long> result = countingWordsModern(input);

        result.forEach((key, value) -> {
            System.out.println("Word:: " + key + " Times:: " + value);
        });
    }

    public static Map<String, Long> countingWords(String input){

        List<String> wordList = Arrays.asList(input.split("\\s+"));

        Map<String, Long> result = new HashMap<>();

        wordList.forEach(key -> {
            if (result.containsKey(key)){
                result.put(key, result.get(key) + 1);
            } else {
                result.put(key, 1L);
            }
        });

        return result;
    }

    public static Map<String, Long> countingWordsModern(String input){
        return Arrays.stream(input.split("\\s+")).collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    }
}
