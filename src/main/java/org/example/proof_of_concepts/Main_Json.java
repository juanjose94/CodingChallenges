package org.example.proof_of_concepts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.proof_of_concepts.models.Person;

import java.util.List;
import java.util.Objects;

public class Main_Json {

    public static void main(String[] args) {
        String jsonString = "[\"string1\", \"string2\", \"string3\"";
        String jsonArrayString = "[{\"name\": \"John\", \"age\": 30}, {\"name\": \"Jane\", \"age\": 25}]";

        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        int numero = 7;
        Integer numero_integer = 7;




        try {
            // Convert JSON string to List of Strings
            List<Person> personList = Objects.nonNull(jsonArrayString) ? objectMapper.readValue(jsonArrayString, new TypeReference<>() {})
                    : null;

            // Print the list
            if (Objects.nonNull(personList)){
                for (Person person : personList) {
                    System.out.println(person.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
