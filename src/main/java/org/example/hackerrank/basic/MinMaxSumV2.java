package org.example.hackerrank.basic;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class MinMaxSumV2 {

    public static void main(String[] args) {
        //TODO: Find the max and min possible summation in a List of integers using Streams

        List<Integer> arr = Arrays.asList(396285104,573261094,759641832,819230764,364801279);

        List<BigInteger> arrBig = arr.stream().map(BigInteger::valueOf).toList();

        minMaxSum(arrBig);
    }


    public static void minMaxSum(List<BigInteger> arr) {
        BigInteger totalSum = arr.stream().reduce(BigInteger.ZERO, BigInteger::add);

        BigInteger min = arr.stream().min(BigInteger::compareTo).get();
        BigInteger max = arr.stream().max(BigInteger::compareTo).get();

        BigInteger minSum = totalSum.subtract(max);
        BigInteger maxSum = totalSum.subtract(min);

        System.out.println(minSum + " " + maxSum);
    }
}
