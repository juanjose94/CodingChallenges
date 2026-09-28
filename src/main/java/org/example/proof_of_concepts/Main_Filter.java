package org.example.proof_of_concepts;

import java.util.Arrays;

public class Main_Filter {

    private static final String[] states = {"State_A","State_B","State_C","State_D"};


    public static void main(String[] args) {

        boolean result = isValidState("State_C");
        System.out.println("Result: " + result);
    }

    private static boolean isValidState(String state) {
        return Arrays.stream(states).anyMatch(s -> s.equals(state));
    }
}
