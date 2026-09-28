package org.example.hackerrank.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class LongEncodedString {

    //TODO: Cada letra del abecedario representa un número (1-26), dado un string debo mappear en un array de tamaño 26 la aparicion de estos números
    // y su frecuencia, con estos criterios:
    // Que sea un entero de 1-9
    // El "#" a la derecha representa un entero de 10-26
    // El numero encerrado en el perentesis representa la cantidad de veces que se repite
    // Ejemplo String: "2110#(2)3(3)226#"
    // Ejemplo de como debe mappearse: 2-1-10#(2)-3(3)-2-26#

    public static void main(String[] args) {
        String input = "1226#24#2(2)226#(2)";

        System.out.println(frequency(input));
    }

    public static List<Integer> frequency(String s) {
        String regexAllconditions = "(1[0-9]|2[0-6])#\\(\\d+\\)|([1-9]\\(\\d+\\))|(1[0-9]|2[0-6])#|([1-9])";

        String regexOneToNine = "[1-9]";
        String regexOneToTweentySix = "(1[0-9]|2[0-6])#";
        String repetitionRegex = "(1[0-9]|2[0-6])#\\(\\d+\\)|[1-9]\\(\\d+\\)";

        Pattern pattern = Pattern.compile(regexAllconditions);
        Matcher matcher = pattern.matcher(s);

        List<Integer> frequencyArray = new ArrayList<>(Stream.generate(() -> 0).limit(26).toList());

        while (matcher.find()) {
            int index;

            String result = matcher.group();
            Matcher regexOneToNineMatcher = Pattern.compile(regexOneToNine).matcher(result);
            Matcher regexOneToTweentySixMatcher = Pattern.compile(regexOneToTweentySix).matcher(result);
            Matcher haveRepeatedMatcher = Pattern.compile(repetitionRegex).matcher(result);

            if (regexOneToNineMatcher.find()) {
                if (regexOneToTweentySixMatcher.find()) {
                    index = Integer.parseInt(regexOneToTweentySixMatcher.group().substring(0,2)) - 1;
                    if (haveRepeatedMatcher.find()) {
                        frequencyArray.set(index,
                                frequencyArray.get(index) + getNumberInsideParenthesis(haveRepeatedMatcher.group()));
                    } else {
                        frequencyArray.set(index,
                                frequencyArray.get(index) + 1);
                    }
                } else {
                    index = Integer.parseInt(regexOneToNineMatcher.group()) - 1;
                    if (haveRepeatedMatcher.find()) {
                        frequencyArray.set(index,
                                frequencyArray.get(index) + getNumberInsideParenthesis(haveRepeatedMatcher.group()));
                    }else {
                        frequencyArray.set(index, frequencyArray.get(index) + 1);
                    }
                }
            }
        }

        return frequencyArray;
    }

    private static int getNumberInsideParenthesis(String number){
        int openParenIndex = number.indexOf('(');
        int closeParenIndex = number.indexOf(')');

        String numberInside = "0";

        if (openParenIndex != -1 && closeParenIndex != -1 && closeParenIndex > openParenIndex) {
            numberInside = number.substring(openParenIndex + 1, closeParenIndex);
        }

        return Integer.parseInt(numberInside);
    }
}
