package org.example.proof_of_concepts.prueba_abstract_class;

public abstract class Figure {

    abstract void drawFigure(String figure);

    public String getFigure(String figure){
        return "Im a " + figure;
    }
}
