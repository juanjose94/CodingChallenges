package org.example.hackerrank.basic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class PlusMinus {
    public static void main(String[] args) {

        //TODO: Calculate the change of a List of integers to contain positive, negative and zero values

        List<Integer> arr = List.of(-4,3,-9,0,4,1);

        int plus = calculatePlus(arr);
        int minus = calculateMinus(arr);
        int zero = calculateZeros(arr);

        BigDecimal plusProb = new BigDecimal(plus).divide(new BigDecimal(arr.size()), 6, RoundingMode.FLOOR);
        BigDecimal minusProb = new BigDecimal(minus).divide(new BigDecimal(arr.size()), 6, RoundingMode.FLOOR);
        BigDecimal zeroProb = new BigDecimal(zero).divide(new BigDecimal(arr.size()), 6, RoundingMode.UP);

        List.of(plusProb,minusProb,zeroProb).forEach(System.out::println);
    }

    private static int calculatePlus(List<Integer> arr) {
        return (int) arr.stream().filter(x -> x.compareTo(0) > 0).count();
    }

    private static int calculateMinus(List<Integer> arr) {
        return (int) arr.stream().filter(x -> x.compareTo(0) < 0).count();
    }

    private static int calculateZeros(List<Integer> arr) {
       return  (int) arr.stream().filter(x -> x.compareTo(0) == 0).count();
    }
}
