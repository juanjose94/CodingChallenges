package org.example.technical_tests.agile_engine;

import org.example.technical_tests.agile_engine.model.UserStats;

import java.util.*;
import java.util.stream.Collectors;

public class FilterMap {
    //TODO: Devolver un mapa del tipo Map<Long, Long>  recibiendo uno o varios Map<String, User>, si el user esta vacio, no debe tenerlo en cuenta
    public static void main(String[] args) {

        Map<String, UserStats> map_1 = new HashMap<>();
        map_1.put("1", UserStats.builder().visitCount(Optional.of(1L)).build());
        map_1.put("2", UserStats.builder().visitCount(Optional.of(2L)).build());

        Map<String, UserStats> map_2 = new HashMap<>();
        map_2.put("3", UserStats.builder().visitCount(Optional.of(3L)).build());
        map_2.put("4", UserStats.builder().visitCount(Optional.of(4L)).build());

        Map<String, UserStats> map_3 = new HashMap<>();
        map_2.put("5", null);

        Map<Long, Long> result = filterMap_V2(map_1, map_2, map_3);
        System.out.println();
        result.forEach((x, y) -> System.out.println("Key: " + x + " Value: " + y));
    }


    @SafeVarargs
    private static Map<Long, Long> filterMap(Map<String, UserStats>... maps){
        return Arrays.stream(maps)
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(
                        entry -> {
                            String keyValue = String.valueOf(entry.getKey());
                            return keyValue != null ? Long.valueOf(keyValue) : 0L;
                        },
                        entry -> {
                            UserStats value = entry.getValue();
                            return value != null ? value.getVisitCount().get() : 0L;
                        },
                        (existing, replacement) -> replacement
                ));
    }


    @SafeVarargs
    private static Map<Long, Long> filterMap_V2(Map<String, UserStats>... visits) {
        return Arrays.stream(visits)
                .flatMap(map -> map.entrySet().stream())
                .filter(entry -> {
                    if (entry.getKey() == null || entry.getValue() == null) return false;
                    try {
                        Long.parseLong(entry.getKey());
                    } catch (NumberFormatException e) {
                        return false;
                    }
                    return entry.getValue().getVisitCount().isPresent();
                })
                .collect(Collectors.toMap(
                        entry -> Long.valueOf(entry.getKey()),
                        entry -> entry.getValue().getVisitCount().orElse(0L),
                        Long::sum
                ));
    }



    Map<Long, Long> filterMap_V3(Map<String, UserStats>... visits) {
        return Arrays.stream(visits)
                .flatMap(map -> map.entrySet().stream())
                .filter(entry -> {
                    if (entry == null || entry.getKey() == null || entry.getValue() == null) return false;
                    try {
                        Long.parseLong(entry.getKey());
                    } catch (NumberFormatException e) {
                        return false;
                    }
                    // Check if visit count is present...
                    UserStats userStats = entry.getValue();
                    return userStats != null &&
                            userStats.getVisitCount() != null &&
                            userStats.getVisitCount().isPresent();
                })
                .collect(Collectors.toMap(
                        entry -> Long.valueOf(entry.getKey()),
                        entry -> entry.getValue().getVisitCount().get(),
                        //Count the result...
                        Long::sum
                ));
    }

    private static Map<Long, Long> filterMap_V4(Map<String, UserStats>... maps) {
        if (maps == null || maps.length == 0) return Map.of();

        return Arrays.stream(maps)
                .filter(Objects::nonNull)
                .flatMap(map -> map.entrySet().stream())
                .filter(entry -> {
                    // Clave no nula y numérica
                    if (entry == null || entry.getKey() == null) return false;
                    try {
                        Long.parseLong(entry.getKey());
                    } catch (NumberFormatException e) {
                        return false;
                    }

                    // Valor no nulo y visitCount presente
                    UserStats userVisit = entry.getValue();
                    return userVisit != null &&
                            userVisit.getVisitCount() != null &&
                            userVisit.getVisitCount().isPresent();
                })
                .collect(Collectors.toMap(
                        entry -> Long.parseLong(entry.getKey()),
                        entry -> entry.getValue().getVisitCount().get(),
                        Long::sum
                ));
    }

}
