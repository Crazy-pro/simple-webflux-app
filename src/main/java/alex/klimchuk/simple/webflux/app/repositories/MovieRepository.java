package alex.klimchuk.simple.webflux.app.repositories;

import alex.klimchuk.simple.webflux.app.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {

}
