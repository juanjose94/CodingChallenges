package org.example.proof_of_concepts.models;


import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@Builder
@ToString
public class Nota {

    private String nota_1;
    private String nota_2;


    public String getNota_1() {
        return nota_1.toLowerCase();
    }

    public String getNota_2() {
        return nota_2.toLowerCase();
    }
}
