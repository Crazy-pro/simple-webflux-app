package alex.klimchuk.simple.webflux.app.services;

import alex.klimchuk.simple.webflux.app.domain.Movie;
import alex.klimchuk.simple.webflux.app.domain.MovieEvent;
import alex.klimchuk.simple.webflux.app.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoOperator;

import java.time.Duration;
import java.util.Date;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public Mono<Movie> getMovieById(String id) {
        return movieRepository.findById(id);
    }

    @Override
    public Flux<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Flux<MovieEvent> streamMovieEvents(String id) {
        return Flux.<MovieEvent>
                        generate(movieEventSynchronousSink -> movieEventSynchronousSink.next(new MovieEvent(id, new Date())))
                .delayElements(Duration.ofSeconds(1L));
    }

}
