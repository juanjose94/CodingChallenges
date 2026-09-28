package org.example.proof_of_concepts;

import java.util.Optional;

public class Main_Optional {

    public static void main(String[] args) {

        Optional<String> myOptional = Optional.of(String.valueOf(Optional.empty()));

        myOptional.ifPresent(x -> System.out.println("Optional del LAMBDA está presente"));

        if (myOptional.isPresent()){
            System.out.println("Optional del IF está presente");
        }
    }
}
