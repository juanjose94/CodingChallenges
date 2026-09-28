package org.example.proof_of_concepts;

import java.util.regex.*;
import java.util.stream.Collectors;

public class Main_regexp {

    public static void main(String[] args) {
        String input = "asdasqweqw   200.2.4.3,asdasdasfasf,1.1.1.8080.dsadasdqweqwe";
        String pattern = "(?:\\d{1,3}\\s*\\.\\s*){3}\\d{1,3}"; // Nueva expresión regular

        // Compilar la expresión regular
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);

        // Usar StringBuilder para concatenar las IPs encontradas separadas por coma
        String result = matcher.results()
                .map(MatchResult::group)
                .collect(Collectors.joining(","));


        // Mostrar el resultado
        System.out.println("result:: " + result);
    }
}
