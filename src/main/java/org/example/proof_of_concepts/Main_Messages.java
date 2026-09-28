package org.example.proof_of_concepts;

import java.util.Objects;

public class Main_Messages {


    private static final String MESSAGE = "{${result}|NULL}";

    public static void main(String[] args) {

        System.out.println(checkValue("true"));
    }

    private static String checkValue(String result) {
        return Objects.nonNull(result) ? MESSAGE + " Is valid" : MESSAGE + " Is null";
    }
}
