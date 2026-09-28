package org.example.proof_of_concepts;

import java.util.Arrays;
import java.util.List;

public class Main_Stream {

    public static void main(String[] args) {

        List<String> someStringNumberList = List.of("2","1","4","5","3");
        List<String> someStringLetterList = List.of("z","h","b","a","b");
        List<Integer> someDivisibleNumber = List.of(2,4,9,3,15,20,8,21);

        int maxValue = someStringNumberList.stream().mapToInt(Integer::valueOf).max().getAsInt();
        double minValueDouble = someStringNumberList.stream().mapToDouble(Double::valueOf).min().getAsDouble();
        List<Integer> someIntegerList = someStringNumberList.stream().map(Integer::valueOf).toList();
        int[] somePrimitiveIntArray = someIntegerList.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(somePrimitiveIntArray);
        String[] somePrimitiveStringArray = someStringLetterList.toArray(new String[0]);
        List<String> someDivisibleNumberToStringList = someDivisibleNumber.stream().map(String::valueOf).toList();
        String[] someDivisibleNumberToStringArray = someDivisibleNumber.stream().map(String::valueOf).toList().toArray(new String[0]);

        Arrays.sort(somePrimitiveStringArray);
        List<Integer> someIntegerListMultipliedByThree = someIntegerList.stream().map(x -> x * 3).toList();
        List<Integer> someDivisibleNumberByThree = someDivisibleNumber.stream().filter(x -> x % 3 == 0).toList();

        System.out.println("Max Value:: " + maxValue);
        System.out.println("Min Value but double:: " + minValueDouble);
        System.out.println("Array of integers but sorted:: " + Arrays.toString(somePrimitiveIntArray));
        System.out.println("Array of strings but sorted:: " + Arrays.toString(somePrimitiveStringArray));
        System.out.println("Array of integers but his values multiplied by 3:: " + someIntegerListMultipliedByThree);
        System.out.println("Array of integers but his values are divisible by 3:: " + someDivisibleNumberByThree);
        System.out.println("Convert Int list to String list:: " + someDivisibleNumberToStringList);
        System.out.println("Convert Int list to String Array:: " + Arrays.toString(someDivisibleNumberToStringArray));
    }
}
