package alex.klimchuk.simple.webflux.app.services;

import alex.klimchuk.simple.webflux.app.domain.Movie;
import alex.klimchuk.simple.webflux.app.domain.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
public interface MovieService {

    Mono<Movie> getMovieById(String id);

    Flux<Movie> getAllMovies();

    Flux<MovieEvent> streamMovieEvents(String id);

}
