package com.rappi.rappi.modelos;

import java.util.HashSet;
import java.util.Set;

public class DFS {
    private Set<Movie> visited = new HashSet<>();

    // Método para ejecutar el algoritmo DFS
    public void ejecutarDFS(Movie movie) {
        if (movie == null || visited.contains(movie)) {
            return;
        }
        visited.add(movie);
        System.out.println("Visiting: " + movie.getTitle());
        for (Person actor : movie.getActors()) {
            // Asume que tienes una forma de obtener las películas en las que ha actuado el actor
            for (Movie m : actor.getMovies()) {
                ejecutarDFS(m);
            }
        }
    }
}