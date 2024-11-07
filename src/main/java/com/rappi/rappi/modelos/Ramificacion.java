package com.rappi.rappi.modelos;

import java.util.List;

public class Ramificacion {
    private int maxActorsAndDirectors = 0;
    private Movie biggestMovie = null;

    // Método para ejecutar el algoritmo de ramificación y poda
    public void ejecutarRamificacionYPoda(List<Movie> movies) {
        for (Movie movie : movies) {
            int actorsAndDirectorsCount = movie.getActors().size() + movie.getDirectors().size();
            if (actorsAndDirectorsCount > maxActorsAndDirectors) {
                maxActorsAndDirectors = actorsAndDirectorsCount;
                biggestMovie = movie;
            }
        }
        if (biggestMovie != null) {
            System.out.println("Pelicula mas grande: " + biggestMovie.getTitle() + " con " + maxActorsAndDirectors + " actores y directores.");
        } else {
            System.out.println("no se encontraron peliculas.");
        }
    }
}