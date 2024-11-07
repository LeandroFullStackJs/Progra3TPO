package com.rappi.rappi.controladores;

import com.rappi.rappi.modelos.*;
import com.rappi.rappi.repositorios.MovieRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

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

    @GetMapping("/backtracking")
    Mono<String> movieBacktracking() {
        return movieRepository.findAll().collectList().map(movies -> {
            BackTracking backTracking = new BackTracking();
            backTracking.ejecutarBacktracking(movies);
            return "Backtracking completed";
        });
    }

    @GetMapping("/dfs")
    Mono<String> movieDFS() {
        return movieRepository.findAll().collectList().map(movies -> {
            if (!movies.isEmpty()) {
                DFS dfs = new DFS();
                dfs.ejecutarDFS(movies.get(0));
            }
            return "DFS completed";
        });
    }

    @GetMapping("/bfs")
    Mono<String> movieBFS() {
        return movieRepository.findAll().collectList().map(movies -> {
            if (!movies.isEmpty()) {
                BFS bfs = new BFS();
                bfs.ejecutarBFS(movies.get(0));
            }
            return "BFS completed";
        });
    }

    @GetMapping("/ramificacion")
    Mono<String> movieRamificacion() {
        return movieRepository.findAll().collectList().map(movies -> {
            Ramificacion ramificacion = new Ramificacion();
            ramificacion.ejecutarRamificacionYPoda(movies);
            return "Ramificación y Poda completed";
        });
    }
}