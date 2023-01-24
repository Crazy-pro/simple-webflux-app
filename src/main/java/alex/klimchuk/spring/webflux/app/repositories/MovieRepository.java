package alex.klimchuk.spring.webflux.app.repositories;

import alex.klimchuk.spring.webflux.app.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Copyright Alex Klimchuk (c) 2023.
 */
public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {

}
