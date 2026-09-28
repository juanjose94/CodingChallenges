package org.example.hackerrank.basic;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class CaesarCypher {

    /* TODO: We need to cypher a given S message with a K value.
    TODO: K value represents the number o spaces that each letter must be moved.
    TODO: Example: If K = 3 and S = There's-a-starman
    TODO: Original alphabet:      abcdefghijklmnopqrstuvwxyz
    TODO: Alphabet rotated +3:    defghijklmnopqrstuvwxyzabc
    TODO: Encrypted message of S: Wkhuh'v'd'vwdupdq

     */


    public static void main(String[] args) {

        System.out.println(caesarCipher("www.abc.xy", 9));
    }

    public static String caesarCipher(String s, int k) {
        String ogAlphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] ogAlphabetChar = ogAlphabet.toCharArray();
        char[] charMessage = s.toCharArray();
        char[] caesarAlphabet = (ogAlphabet.substring(k) + ogAlphabet.substring(0, k)).toCharArray();
        StringBuilder encryptedMessage = new StringBuilder();

        for (int i = 0; i < charMessage.length; i++) {
            if (Character.isUpperCase(charMessage[i])) {
                encryptedMessage.append(Character.toUpperCase(caesarAlphabet[getOgIndex(charMessage[i], ogAlphabetChar)]));
            } else {
                if (isSpecialCharacter(charMessage[i])) {
                    encryptedMessage.append(charMessage[i]);
                } else {
                    encryptedMessage.append(caesarAlphabet[getOgIndex(charMessage[i], ogAlphabetChar)]);
                }
            }
        }

        return encryptedMessage.toString();
    }

    public static boolean isSpecialCharacter(char character){
        return Pattern.matches("[^a-zA-Z0-9]", String.valueOf(character));
    }

    public static int getOgIndex(char character, char[] ogAlphabet){
        int ogIndex = 0;
        for (int j = 0; j < ogAlphabet.length; j++) {
            if(ogAlphabet[j] == Character.toLowerCase(character)){
                ogIndex = j;
            }
        }
        return ogIndex;
    }
}
