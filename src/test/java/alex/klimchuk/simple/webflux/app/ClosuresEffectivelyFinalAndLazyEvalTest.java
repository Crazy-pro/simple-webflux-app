package alex.klimchuk.simple.webflux.app;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
public class ClosuresEffectivelyFinalAndLazyEvalTest {

    @Test
    public void testLambdaExample() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        numbers.stream()
                .map(number -> number * 2)
                .forEach(System.out::println);
    }

    @Test
    public void testClosureExample() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Integer multiplier = 2;

        numbers.stream()
                .map(number -> number * multiplier)
                .forEach(System.out::println);
    }

    @Test
    public void testClosureUsingFinal() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        final Integer multiplier = 2;

        Stream<Integer> numberStream = numbers.stream()
                .map(number -> number * multiplier);

        numberStream.forEach(System.out::println);
    }

    @Test
    public void testClosureEffectivelyFinal() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Integer multiplier = 2;

        Stream<Integer> numberStream = numbers.stream()
                .map(number -> number * multiplier);

        numberStream.forEach(System.out::println);
    }

    @Test
    public void testBreakingFinal() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        final Integer[] multiplier = {2};

        Stream<Integer> numberStream = numbers.stream()
                .map(number -> number * multiplier[0]);

        multiplier[0] = 0;

        numberStream.forEach(System.out::println);
    }

}
