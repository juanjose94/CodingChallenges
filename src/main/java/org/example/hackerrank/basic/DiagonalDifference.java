package org.example.hackerrank.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DiagonalDifference {

    public static void main(String[] args) {

        //TODO: Calculate the difference of the sum of all matrix diagonals

        List<List<Integer>> arr = getBidimensionalList();

        int firstDiagonal = diagonalDifference(arr);

        for (List<Integer> row : arr) {
            Collections.reverse(row);  // Reverse each row
        }

        int secondDiagonal = diagonalDifference(arr);

        System.out.println("The diagonal sum is:: " + Math.abs(firstDiagonal - secondDiagonal));

    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        // Sums: 0,0; 0,2; 1,1; 2,0; 2,2
        int i = 0;
        int j = 0;
        int result = 0;

        for (List<Integer> i_list: arr) {
            if (i_list.size() != 1){
                for (Integer j_list : i_list) {
                    if (i == j){
                        result = result + j_list;
                    }
                    j ++;
                }
                j = 0;
                i ++;
            }
        }

        return result;
    }


    private static List<List<Integer>> getBidimensionalList(){
        List<Integer> row_0 = Arrays.asList(3);
        List<Integer> row_1 = Arrays.asList(11,2,4);
        List<Integer> row_2 = Arrays.asList(4,5,6);
        List<Integer> row_3 = Arrays.asList(10,8,-12);

        return List.of(row_0, row_1,row_2,row_3);
    }
}
