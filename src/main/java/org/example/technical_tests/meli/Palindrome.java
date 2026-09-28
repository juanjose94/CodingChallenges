package org.example.technical_tests.meli;

import java.util.Objects;
import java.util.stream.IntStream;


public class Palindrome {

    public static void main(String[] args) {
        //TODO validate if a string is a palindrome
        String palindrome = "- La ruta nos aportó otro paso natural. -";
        String nonPalindrome = "hello";

        System.out.println("Is " + palindrome + " is palindrome?? :: " + isPalindrome(palindrome));
        System.out.println("Is " + nonPalindrome + " is palindrome?? :: " + isPalindrome(nonPalindrome));

        System.out.println();
    }

    public static boolean isPalindrome(String cadena) {

        String cleanString = cleanAccent(cadena.toLowerCase())
                .replaceAll("[^a-zA-Z]", "");

        char[] wordArray = cleanString.toLowerCase().replace(" ", "").toCharArray();

        int mirrorLength = wordArray.length - 1;

        return IntStream.range(0, mirrorLength/2)
                .allMatch(i -> Objects.equals(wordArray[i], wordArray[mirrorLength - i]));
    }

    private static String cleanAccent(String word){
        return word.replace("á", "a")
                .replace("é", "e")
                .replace("í", "i")
                .replace("ó", "o")
                .replace("ú", "u");
    }
}
