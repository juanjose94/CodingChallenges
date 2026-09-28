package org.example.leetcode.basic;

import java.util.Arrays;

public class TwoSum {

/*  TODO: Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    TODO: You may assume that each input would have exactly one solution, and you may not use the same element twice.
    TODO: You can return the answer in any order.

    TODO:        Example 1:
    TODO: Input: nums = [2,7,11,15], target = 9
    TODO: Output: [0,1]
    TODO: Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].*/


    public static void main(String[] args) {

        int[] intArray = new int[]{2,4,11,3};
        int[] result = getTwoSum(intArray, 14);

        System.out.println(Arrays.toString(result));
    }

    public static int[] getTwoSum(int[] intArray, int target){
        int result_i = 0;
        int result_j = 0;
        boolean sumAlreadyFounded = false;

        for (int i = 0; i < intArray.length; i++) {
            for (int j = 1; j < intArray.length; j++) {
                int sum = intArray[i] + intArray[j];
                if (sum == target && !sumAlreadyFounded && i != j){
                    result_i = i;
                    result_j = j;
                    sumAlreadyFounded = true;
                }
            }
        }
        return new int[]{result_i, result_j};
    }
}
