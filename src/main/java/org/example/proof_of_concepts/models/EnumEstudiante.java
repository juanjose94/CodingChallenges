package org.example.proof_of_concepts.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
public enum EnumEstudiante {

    BIEN(".BIEN"),
    MAL(".MAL"),
    MASO(".MASO"),
    SALUD(".HaySalud");

    private final String value;
    EnumEstudiante(String value) {
        this.value = value;
    }


}
