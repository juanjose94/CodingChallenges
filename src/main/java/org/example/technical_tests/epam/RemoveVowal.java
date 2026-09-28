package org.example.technical_tests.epam;

public class RemoveVowal {

    public static void main(String[] args) {
        //TODO: Based in a given string, remove his vowals
        //TODO: Input: Hellow //Output: Hllw

        String input = "Hellow";

        System.out.println("The output is: " + removeVowal(input));
    }

    public static String removeVowal(String input){

        //1: Convert the input to a Iterable form (String[] or Char[] maybe?)
        char[] inputChar = input.toCharArray();
        StringBuilder result = new StringBuilder();
        //2: Iterate over the letters.
        for (char c : inputChar) {
            String charStringValue = String.valueOf(c);
            //3: Remove Vowals
            if (!isVowal(charStringValue)) {
                result.append(charStringValue);
            }
        }

        //4: Reconvert the array to a string
        return result.toString();
    }

    public static boolean isVowal(String letter){
       return letter.equalsIgnoreCase("a") || letter.equalsIgnoreCase("e")
               || letter.equalsIgnoreCase("i") || letter.equalsIgnoreCase("o")
               || letter.equalsIgnoreCase("u");
    }

}
