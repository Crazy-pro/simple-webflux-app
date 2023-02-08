package alex.klimchuk.simple.webflux.app;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
public class FunctionalProgrammingExamplesTest {
    
    @Test
    public void testFunctionWith4Things() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() { 
                System.out.println(" In thread t1"); 
            }
        });

        t1.start();

        System.out.println("In Main Test");
    }

    @Test
    public void testLambdaExpression() {
        Thread t1 = new Thread(() -> System.out.println("Silence of the Lambdas"));

        t1.start();

        System.out.println("In Main Test");
    }

    @Test
    public void testListIteratorHighCeremony() {
        List<String> dogs = Arrays.asList("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        for (int i = 0; i < dogs.size(); i++) {
            System.out.println(dogs.get(i));
        }
    }

    @Test
    public void testListIteratorLessCeremonyExternalIter() {
        List<String> dogs = Arrays.asList("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        for (String doggy : dogs) {
            System.out.println(doggy);
        }
    }

    @Test
    public void testListInternalIterConsumer() {
        List<String> dogs = Arrays.asList("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        dogs.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }

    @Test
    public void testListInternalIterLambdaMethod() {
        List<String> dogs = Arrays.asList("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        dogs.forEach((String s) -> System.out.println(s));
    }

    @Test
    public void testListInternalIterLambdaMethodTypeInference() {
        List<String> dogs = Arrays.asList("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        dogs.forEach((s) -> System.out.println(s));
    }

    @Test
    public void testListInternalIterLambdaMethodTypeInferenceJustOne() {
        List<String> dogs = Arrays.asList("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        dogs.forEach(s -> System.out.println(s));
    }

    @Test
    public void testListInternalIterLambdaMethodTypeJava8MethodRef() {
        List<String> dogs = Arrays.asList("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        dogs.forEach(System.out::println);
    }

    @Test
    public void testCountDogsWithSixCharactersImp() {
        List<String> dogs = Arrays.asList("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        int dogCount = 0;

        for (String dog : dogs) { 
            if (dog.length() == 6) {
                dogCount++; 
            }
        }

        System.out.println(dogCount);
    }

    @Test
    public void testCountDogsWithEightCharactersDec() {
        List<String> dogs = Arrays.asList("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        System.out.println(dogs.stream() 
                .filter(dog -> dog.length() == 6) 
                .collect(Collectors.toList()) 
                .size());
    }
    
}
