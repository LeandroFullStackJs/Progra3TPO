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
            for (Movie m : getMoviesActedIn(actor, visited)) {
                ejecutarDFS(m);
            }
        }
    }

    private Set<Movie> getMoviesActedIn(Person actor, Set<Movie> allMovies) {
        Set<Movie> moviesActedIn = new HashSet<>();
        for (Movie movie : allMovies) {
            if (movie.getActors().contains(actor)) {
                moviesActedIn.add(movie);
            }
        }
        return moviesActedIn;
    }
}