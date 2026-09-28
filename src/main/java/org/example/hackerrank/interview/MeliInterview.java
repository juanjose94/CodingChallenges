package org.example.hackerrank.interview;

import java.util.ArrayList;
import java.util.List;

public class MeliInterview {

    public static void main(String[] args) {
        System.out.println("lets do this");



    }

    public static List<Integer> mergeArrays(List<Integer> a, List<Integer> b) {
        // Add both elements in a new array
        // Sorting with a data structure.

        List<Integer> arrayMerged = new ArrayList<>(a);
        arrayMerged.addAll(b);

        return sortArrays(arrayMerged);
    }

    private static List<Integer> sortArrays(List<Integer> arrayMerged){

        for (int i = 0; i < arrayMerged.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arrayMerged.size(); j++) {
                if (arrayMerged.get(j) < arrayMerged.get(min)) min = j;
            }
            int temp = arrayMerged.get(i);
            arrayMerged.set(i, arrayMerged.get(min));
            arrayMerged.set(min, temp);
        }

        return arrayMerged;
    }

}
