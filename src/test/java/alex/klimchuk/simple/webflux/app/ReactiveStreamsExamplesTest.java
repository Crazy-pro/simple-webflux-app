package alex.klimchuk.simple.webflux.app;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
public class ReactiveStreamsExamplesTest {

    @Test
    public void testSimpleStreamExample() {
        Flux<String> dogs = Flux.just("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        dogs.toStream()
                .forEach(System.out::println);
    }

    @Test
    public void testSimpleStreamExample2() {
        Flux<String> dogs = Flux.just("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        dogs.subscribe(System.out::println);
    }

    @Test
    public void testSimpleStreamExample3() {
        Flux<String> dogs = Flux.just("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        dogs.doOnEach(dog -> System.out.println(dog.get()));
    }

    @Test
    public void testSimpleStreamExample4() {
        Flux<String> dogs = Flux.just("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        dogs.doOnEach(dog -> System.out.println(dog.get())).subscribe();
    }

    @Test
    public void testSimpleStreamExample5WithSubscriber() {
        Flux<String> dogs = Flux.just("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        dogs.subscribe(((s) -> {
            System.out.println(s);
        }), null, (() -> {
            System.out.println("Woot! all Done");
        }));
    }

    @Test
    public void testSimpleStreamExample5WithSubscriberConsumers() {
        Flux<String> dogs = Flux.just("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        Consumer<String> println = System.out::println;

        Consumer<Throwable> errorHandler = e -> System.out.println("Some Error Occurred");

        Runnable allDone = () -> System.out.println("Woot! All Done!");

        dogs.subscribe(println, errorHandler, allDone);
    }

    @Test
    public void testMapStreamExample() {
        Flux<String> dogs = Flux.just("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        dogs.map(String::length)
                .doOnEach(System.out::println)
                .subscribe();
    }

    @Test
    public void testFilterStreamExample() {
        Flux<String> dogs = Flux.just("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        dogs.filter(s -> s.length() == 6)
                .subscribe(System.out::println);
    }

    @Test
    public void testFilterAndLimitStreamExample() {
        Flux<String> dogs = Flux.just("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        dogs.filter(s -> s.length() == 6)
                .take(2)
                .subscribe(System.out::println);
    }

    @Test
    public void testFilterAndSortStreamExample() {
        Flux<String> dogs = Flux.just("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        dogs.filter(s -> s.length() == 6)
                .take(2)
                .sort()
                .subscribe(System.out::println);
    }

    @Test
    public void testFilterAndSortStreamWithCollectorExample() {
        Flux<String> dogs = Flux.just("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        dogs.filter(s -> s.length() == 6)
                .take(3)
                .sort()
                .collect(Collectors.joining(", "))
                .subscribe(System.out::println);
    }

    @Test
    public void testFlatMap() {
        Flux<List<List<Integer>>> listFlux = Flux.just(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6)));

        listFlux.flatMap(lists -> Flux.fromIterable(lists))
                .flatMap(Flux::fromIterable)
                .subscribe(System.out::println);
    }

    @Test
    public void testFlatMap2() {
        Flux<List<List<Integer>>> listFlux = Flux.just(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6)));

        listFlux.flatMap(lists -> Flux.fromIterable((lists.stream()
                        .flatMap(Collection::stream))
                        .collect(Collectors.toList())))
                .subscribe(System.out::println);
    }

    @Test
    public void testReduction() {
        Flux<String> dogs = Flux.just("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        dogs.reduce((a, b) -> a + " - " + b).subscribe(System.out::println);
    }

}
