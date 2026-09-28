package org.example.proof_of_concepts;

import org.example.proof_of_concepts.models.Estudiante;
import org.example.technical_tests.slalom.SortNameLists;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Intro with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Mondaqueado maña!");

        Estudiante estudiante = new Estudiante();

        SortNameLists sortNameLists = new SortNameLists();

        // Press Mayús+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Mayús+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }

        String ogAlphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(ogAlphabet.substring(3) + ogAlphabet.substring(0,3));
    }
}