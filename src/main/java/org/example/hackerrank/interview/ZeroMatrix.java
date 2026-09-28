package org.example.hackerrank.interview;

import java.util.ArrayList;
import java.util.Arrays;

public class ZeroMatrix {

    public static void main(String[] args) {

        //TODO Step 1: Create matrix for save all zero places.
        //TODO Step 2: Check if given matrix is a rectangular or square matrix
        //TODO Step 3: Save all zero places:
        //TODO Step 4: Create an algorithm to mark the zeros

        //int[][] matrix = {{1,2,3},{4,0,6},{7,8,9}}; //Square Matrix
        int[][] matrix = {{1,2,3},{4,0,6},{7,8,9},{7,8,0}}; //Rectangular Matrix

        boolean isSquareMatrix = isSquareMatrix(matrix);

        Arrays.stream(getZeroMatrixRectangular(matrix, isSquareMatrix))
                .forEach(System.out::println);
    }

    public static int[][] getZeroMatrixRectangular(int[][] matrix, boolean isSquareMatrix){
        ArrayList<int[]> zeroMatrix = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0){
                    addZeroPosition(zeroMatrix, i,j);
                }
            }
        }
        zeroMatrix.forEach(position -> markZerosRectangular(matrix, position[0], position[1], isSquareMatrix));
        return matrix;
    }

    private static void markZerosRectangular(int[][] matrix, int i_position, int j_position, boolean isSquareMatrix){
        if (isSquareMatrix){
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (i == j_position){
                        matrix[j][j_position] = 0;
                    }
                    if (j == i_position){
                        matrix[i_position][i] = 0;
                    }
                }
            }
        }
        else{
            for (int i = 0; i < matrix[i].length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (i == j_position){
                        matrix[j][j_position] = 0;
                    }
                    if (j == i_position){
                        matrix[i_position][i] = 0;
                    }
                }
            }
        }
    }

    private static void addZeroPosition(ArrayList<int[]> zeroMatrix, int i_position, int j_position){
        int[] zeroPosition = {i_position,j_position};
        zeroMatrix.add(zeroPosition);
    }

    private static boolean isSquareMatrix(int[][] matrix){
        boolean result = true;
        for (int[] ints : matrix) {
            result = result && (matrix.length == ints.length);
        }
        return result;
    }
}
