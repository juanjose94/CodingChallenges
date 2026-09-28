package org.example.proof_of_concepts;

import java.time.Instant;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Main_Date {

    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println("instant::" + instant);
        Instant newInstant = instant.minus(365, ChronoUnit.DAYS);
        System.out.println("instant minus::" + newInstant);
    }
}
