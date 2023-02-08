package alex.klimchuk.simple.webflux.app.bootstrap;

import alex.klimchuk.simple.webflux.app.domain.Movie;
import alex.klimchuk.simple.webflux.app.repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@Component
@AllArgsConstructor
public class MovieBootstrap implements CommandLineRunner {

    private final MovieRepository movieRepository;


    @Override
    public void run(String... args) throws Exception {
        movieRepository.deleteAll()
                .thenMany(Flux.just("Death Race", "Undertaker", "Naruto", "Silence game")
                        .map(Movie::new))
                        .flatMap(movieRepository::save)
                        .subscribe(null, null, () -> {
                            movieRepository.findAll()
                                    .subscribe(System.out::println);
                        });
    }

}
