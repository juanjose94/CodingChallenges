package org.example.hackerrank.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeConversion {

    public static void main(String[] args) {

        //TODO: Convert normal time in a military time

        String input = "12:45:00pm";

        System.out.println("result: " + timeConversion(input));

    }

    public static String timeConversion(String input){
        Pattern pattern = Pattern.compile("(?i)(am|pm)$");
        Matcher matcher = pattern.matcher(input);

        String time = matcher.find() ? matcher.group() : null;
        String hour = input.substring(0,2);
        String minutesSeconds = input.substring(2,8);

        String validation = Integer.valueOf(hour).compareTo(12) == 0 ? "00" + minutesSeconds : Integer.valueOf(hour)
                + 12 + minutesSeconds;

        if (Integer.valueOf(hour).compareTo(12) == 0){
            if (time.equalsIgnoreCase("AM")){
                return "00" + minutesSeconds;
            }else {
                return Integer.valueOf(hour) + minutesSeconds;
            }
        }
        if (time.equalsIgnoreCase("PM")){
            return  Integer.valueOf(hour) + 12 + minutesSeconds;
        }else {
            if (Integer.valueOf(hour).compareTo(9) > 0){
                return validation;
            }
            return "0" + Integer.valueOf(hour) + minutesSeconds;
        }
    }

}
