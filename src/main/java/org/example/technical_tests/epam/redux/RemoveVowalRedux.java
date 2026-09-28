package org.example.technical_tests.epam.redux;

public class RemoveVowalRedux {

    public static void main(String[] args) {
        //TODO: Based in a given string, remove his vowals
        //TODO: Input: Hellow //Output: Hllw

        String input = "Hellow";

        System.out.println("The output is: " + removeVowal(input));
    }

    private static String removeVowal(String input) {

        // 1. Convert the input to a char array
        // 2. Validate if the char is a vowal.
        // 3. If it is not a vowal, append it to the result.
        // 4. Return the result as a string.

        //1.
        return input.chars().mapToObj(c -> (char) c)
                .filter(c -> !isVowal(c))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    private static boolean isVowal(Character c) {
        return "AEIOUaeiou".indexOf(c) >= 0;
    }
}
