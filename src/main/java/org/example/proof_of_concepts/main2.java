package org.example.proof_of_concepts;

import org.w3c.dom.ls.LSOutput;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.random.RandomGenerator;

import static java.util.Map.entry;


public class main2 {

    private static HashMap<String, String> map = new HashMap<>();

    private static Map<String, String> map_2 = new HashMap<>();
//    private static Map<String, String> map_2 = Map.ofEntries(entry("a", "b"), entry("c", "d"));


    public static void main(String[] args) {

        map.put("user@example.com", "id_1");
        System.out.println("Está vacio?:: " + map.isEmpty());
        map.put("user2@example.com", "id_2");
        map.put("user3@example.com", "id_3");
        map.put("user4@example.com", "id_4");
        System.out.println("Resultado:: " + verificarHashmap("user2 @example.com"));
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").substring(0,24);
        System.out.println("Alfanumeric_string:: " + uuid);
        añadirHashmap("user@example.com", uuid);
        añadirHashmap("user_2@example.com", uuid);
        añadirHashmap("user_3@example.com", uuid);
        añadirHashmap("user_4@example.com", uuid);
        map.entrySet().forEach(System.out::println);
    }

    private static String verificarHashmap(String email){
        return map.getOrDefault(email, "no hay nada");
    }

    private static void añadirHashmap(String email, String uuid){
        map_2.put(email, uuid);
    }
}
