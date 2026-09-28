package org.example.proof_of_concepts;

import org.apache.commons.collections4.CollectionUtils;
import org.example.proof_of_concepts.models.Estudiante;
import org.example.proof_of_concepts.models.Nota;

import java.time.Instant;
import java.util.*;

public class MainEstudiante {

    private static Estudiante estudiante = new Estudiante();

    public static void main(String[] args) {

        List<Estudiante> estudianteList = inicializarEstudiante();

        List<Estudiante> estudianteGradoSuperior = estudianteList.stream()
                .filter(e -> e.getGrado() == 11).toList();

        estudianteGradoSuperior.forEach(System.out::println);

        int maxValue = estudianteList.stream().max(Comparator.comparingInt(Estudiante::getGrado)).get().getGrado();

        List<Estudiante> estudianteGradoSuperior_2 = estudianteList.stream()
                .filter(e -> e.getGrado() == maxValue).peek(e -> e.setNota(Nota.builder().nota_1("1.0").nota_2("1.0").build())).toList();

        estudianteGradoSuperior_2.forEach(System.out::println);

        List<Estudiante> estudianteListVacio = new ArrayList<>();

        boolean probarCondicion = estudianteList.stream().filter(estudiante -> !Objects.equals(estudiante.getStatus(), "DESCONOCIDO"))
                .allMatch(estudiante -> Objects.equals(estudiante.getStatus(), "MATRICULADO") || Objects.equals(estudiante.getStatus(), "MONDAQUEADO"));


        List<Estudiante> estudianteVacio = new ArrayList<>();
        List<Estudiante> estudianteNull = null;
        System.out.println("IsEmpty?" + CollectionUtils.isEmpty(estudianteVacio) + "AND NULL" + CollectionUtils.isEmpty(estudianteNull));

        System.out.println(probarCondicion);

        Boolean booleano = null;

        System.out.println("resultado de mi booleano:: " + Boolean.TRUE.equals(booleano));

        System.out.println("Time evaluated:: " + convertTime(false, null));
    }

    private static List<Estudiante> inicializarEstudiante() {
        Estudiante estudiante_1 = Estudiante.builder().name("juan").grado(11).status("DESCONOCIDO").build();
        Estudiante estudiante_2 = Estudiante.builder().name("Maria").grado(11).status("DESCONOCIDO").build();
        Estudiante estudiante_3 = Estudiante.builder().name("Mabel").grado(10).status("MATRICULADO").build();
        Estudiante estudiante_4 = Estudiante.builder().name("Manu").grado(9).status("MONDAQUEADO").build();

        return Arrays.asList(estudiante_1, estudiante_2, estudiante_3, estudiante_4);
    }


    private static Instant convertTime(Boolean flag, Instant time) {
        if (Boolean.TRUE.equals(flag)) {
            return null;
        }
        return time;
    }
}
