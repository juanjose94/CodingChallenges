package org.example.hackerrank.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LonelyInteger {


    public static void main(String[] args) {

        //Todo: find the non repeated element in array

        List<Integer> itemslist = Arrays.asList(10, 12, 10, 10, 33, 40, 40, 61, 61);

        System.out.println("The unique element is:: " + lonelyinteger(itemslist));
    }

    public static int lonelyinteger(List<Integer> a) {
        return a.stream().filter(x -> Collections.frequency(a, x) == 1).findAny().get();
    }

}
