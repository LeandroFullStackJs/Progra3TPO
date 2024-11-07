package com.rappi.rappi.modelos;

import java.util.ArrayList;
import java.util.List;

// encontrar una combinación de películas que cumpla con ciertos criterios, como tener un número mínimo de actores y directores.

public class BackTracking {
    private List<Movie> bestCombination = new ArrayList<>();
    private int maxActorsAndDirectors = 0;

    // Método para ejecutar el algoritmo de backtracking
    public void ejecutarBacktracking(List<Movie> movies) {
        List<Movie> currentCombination = new ArrayList<>();
        backtrack(movies, currentCombination, 0);
        if (!bestCombination.isEmpty()) {
            System.out.println("Mejor combinación de películas:");
            for (Movie movie : bestCombination) {
                System.out.println(movie.getTitle());
            }
            System.out.println("Con un total de " + maxActorsAndDirectors + " actores y directores.");
        } else {
            System.out.println("No se encontró una combinación adecuada de películas.");
        }
    }

    private void backtrack(List<Movie> movies, List<Movie> currentCombination, int start) {
        int currentActorsAndDirectors = calculateActorsAndDirectors(currentCombination);
        if (currentActorsAndDirectors > maxActorsAndDirectors) {
            maxActorsAndDirectors = currentActorsAndDirectors;
            bestCombination = new ArrayList<>(currentCombination);
        }

        for (int i = start; i < movies.size(); i++) {
            currentCombination.add(movies.get(i));
            backtrack(movies, currentCombination, i + 1);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    private int calculateActorsAndDirectors(List<Movie> movies) {
        int count = 0;
        for (Movie movie : movies) {
            count += movie.getActors().size() + movie.getDirectors().size();
        }
        return count;
    }
}
