package com.rappi.rappi.controladores;

import com.rappi.rappi.modelos.BackTracking;
import com.rappi.rappi.modelos.Movie;
import com.rappi.rappi.repositorios.MovieRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @PutMapping
    Mono<Movie> createOrUpdateMovie(@RequestBody Movie newMovie) {
        return movieRepository.save(newMovie);
    }

    @GetMapping(value = { "", "/" }, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Movie> getMovies() {
        return movieRepository.findAll();
    }

//    asi deberian ser todos los endpoints de los algoritmos
//    @GetMapping("/backtracking")
//    Mono<Movie> movieBacktracking() {
//        return BackTracking.ejecutar(movieRepository.findAll());
//    }

}
