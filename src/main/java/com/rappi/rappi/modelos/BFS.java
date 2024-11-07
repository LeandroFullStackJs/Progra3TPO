package com.rappi.rappi.modelos;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS {
    private Set<Movie> visited = new HashSet<>();

    // Método para ejecutar el algoritmo BFS
    public void ejecutarBFS(Movie movie) {
        if (movie == null) {
            return;
        }
        Queue<Movie> queue = new LinkedList<>();
        queue.add(movie);
        visited.add(movie);

        while (!queue.isEmpty()) {
            Movie current = queue.poll();
            System.out.println("Visiting: " + current.getTitle());
            for (Person actor : current.getActors()) {
                for (Movie m : actor.getMovies()) {
                    if (!visited.contains(m)) {
                        queue.add(m);
                        visited.add(m);
                    }
                }
            }
        }
    }
}