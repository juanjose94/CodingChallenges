package org.example.proof_of_concepts;

import org.apache.commons.lang3.StringUtils;
import org.example.proof_of_concepts.models.EnumEstudiante;

import java.util.List;
import java.util.Objects;

import static org.example.proof_of_concepts.models.EnumEstudiante.*;

public class Main_Enums {


    public static void main(String[] args) {

        String string_bien = "bien.com.co";
        String string_mal = null;
//        List<String> comparable_enum = List.of(string_bien, string_mal);

//        System.out.println("resultado:: " + EnumEstudiante.valueOf(string_bien.toUpperCase()));

//        System.out.println("resultado:: " + string_mal.length());

        String regexp = "^([^.]+).*";

        String first_group = "$1";

        String expression = StringUtils.isBlank(string_mal) ? "" : string_mal.replaceAll(regexp, first_group);

        System.out.println("resultado:: " + expression );

    }

    private static boolean isValidEnum(String value) {
        return getEnumList().stream().anyMatch(x -> Objects.equals(x, EnumEstudiante.valueOf(value.toUpperCase())));
    }

    public static List<EnumEstudiante> getEnumList(){
        return List.of(BIEN,MAL,MASO,SALUD);
    }
}