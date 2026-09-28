package org.example.proof_of_concepts.sort_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingAlgotithmsObjectList {

    public static void main(String[] args) {
        List<Persona> personas = Arrays.asList(
                new Persona("Ana", 32),
                new Persona("Luis", 25),
                new Persona("Carlos", 40),
                new Persona("Marta", 29)
        );

        // Ejemplo: ordenar con bubbleSort
        selectionSort(personas);
        personas.forEach(System.out::println);
    }

    public static void bubbleSort(List<Persona> personas) {
        int n = personas.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (personas.get(j).getEdad() > personas.get(j + 1).getEdad()) {
                    Collections.swap(personas, j, j + 1);
                }
            }
        }
    }

    public static void selectionSort(List<Persona> personas) {
        int n = personas.size();
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (personas.get(j).getEdad() < personas.get(minIdx).getEdad()) {
                    minIdx = j;
                }
            }
            Collections.swap(personas, i, minIdx);
        }
    }

    public static void insertionSort(List<Persona> personas) {
        for (int i = 1; i < personas.size(); i++) {
            Persona key = personas.get(i);
            int j = i - 1;
            while (j >= 0 && personas.get(j).getEdad() > key.getEdad()) {
                personas.set(j + 1, personas.get(j));
                j--;
            }
            personas.set(j + 1, key);
        }
    }

    public static void mergeSort(List<Persona> personas) {
        if (personas.size() > 1) {
            int mid = personas.size() / 2;
            List<Persona> left = new ArrayList<>(personas.subList(0, mid));
            List<Persona> right = new ArrayList<>(personas.subList(mid, personas.size()));

            mergeSort(left);
            mergeSort(right);
            merge(personas, left, right);
        }
    }

    private static void merge(List<Persona> personas, List<Persona> left, List<Persona> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getEdad() <= right.get(j).getEdad()) {
                personas.set(k++, left.get(i++));
            } else {
                personas.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) {
            personas.set(k++, left.get(i++));
        }
        while (j < right.size()) {
            personas.set(k++, right.get(j++));
        }
    }

    public static void quickSort(List<Persona> personas, int low, int high) {
        if (low < high) {
            int pi = partition(personas, low, high);
            quickSort(personas, low, pi - 1);
            quickSort(personas, pi + 1, high);
        }
    }

    private static int partition(List<Persona> personas, int low, int high) {
        Persona pivot = personas.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (personas.get(j).getEdad() < pivot.getEdad()) {
                i++;
                Collections.swap(personas, i, j);
            }
        }
        Collections.swap(personas, i + 1, high);
        return i + 1;
    }

    public static void heapSort(List<Persona> personas) {
        int n = personas.size();

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(personas, n, i);

        for (int i = n - 1; i > 0; i--) {
            Collections.swap(personas, 0, i);
            heapify(personas, i, 0);
        }
    }

    private static void heapify(List<Persona> personas, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && personas.get(left).getEdad() > personas.get(largest).getEdad())
            largest = left;

        if (right < n && personas.get(right).getEdad() > personas.get(largest).getEdad())
            largest = right;

        if (largest != i) {
            Collections.swap(personas, i, largest);
            heapify(personas, n, largest);
        }
    }

}

class Persona {
    String nombre;
    int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public String toString() {
        return nombre + " (" + edad + ")";
    }
}
