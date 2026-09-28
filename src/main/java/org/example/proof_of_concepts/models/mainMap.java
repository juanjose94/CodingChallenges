package org.example.proof_of_concepts.models;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class mainMap {
    public static void main(String[] args) {

        Map<String, Long> map = new HashMap<>();

    }


    private static void dummy(Map<String, Long>... maps){

        Map<Long, Long> count = Arrays.stream(maps)  // Convertir la lista de varargs en un Stream de Maps
                .flatMap(map -> map.entrySet().stream())  // Convertir cada Map en un Stream de sus entradas
                .collect(Collectors.toMap(
                        entry -> {
                            String value = String.valueOf(entry.getValue());
                            return value != null ? Long.valueOf(value) : 0L; // Convertir valor a Long, o usar 0L si es nulo
                        },
                        entry -> Long.valueOf(entry.getValue()), // Convertir el valor a Long
                        (existing, replacement) -> replacement  // Resolver conflictos si hay claves duplicadas
                ));
    }
}
