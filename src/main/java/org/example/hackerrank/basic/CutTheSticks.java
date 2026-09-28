package org.example.hackerrank.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CutTheSticks {

    //TODO: Given a List of random integers, you must remove the minor length element/s and minus the to the other ones
    //TODO: The number of cutted elements must be returned in another List.
    //TODO: Example: input: [5, 4, 4, 2, 2, 8], output [6, 4, 2, 1]
    //TODO: Explanation
    //TODO: First cut -> minor element: 2 -> [3, 2, 2, 6] output: [6]
    //TODO: Second cut -> minor element: 2 -> [3, 4] output: [6, 4]
    //TODO: Third cut -> minor element: 3 -> [1] output: [6, 4, 2]
    //TODO: Final cut -> minor element: 3 -> [1] output: [6, 4, 2, 1]

    public static void main(String[] args) {

        //1. Identify the lowest value.
        //2. Remove and get the count of removed elements.
        //3. Repeat until get only one element.

        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(3);
        input.add(3);
        input.add(2);
        input.add(1);

        cutTheSticks(input).forEach(System.out::println);
    }

    public static List<Integer> cutTheSticks(List<Integer> arr) {
        List<Integer> result = new ArrayList<>();

        return recursiveCutStick(arr, result);
    }

    public static List<Integer> recursiveCutStick(List<Integer> currentList, List<Integer> result) {
        if (currentList.isEmpty()){
            return result;
        }
        List<Integer> cuttedList = new ArrayList<>();
        int cutCount = 0;
        int shortestLength = currentList.stream().mapToInt(Integer::intValue).min().getAsInt();
        for (int i = 0; i < currentList.size(); i++) {
            cuttedList.add(currentList.get(i) - shortestLength);
            cutCount ++;
        }
        result.add(cutCount);

        return recursiveCutStick(cuttedList.stream().filter(x -> x != 0).collect(Collectors.toList()), result);
    }

}
