package com.program;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class FunctionalInterfaceEx {

    public static void main(String[] args) {
        List<String> courses =List.of("java", "spring", "hibernate", "maven", "git" ,"jpa" ,"kafka" ,"servlet", "jsp" , "spring boot");
        List<Integer> numbers= List.of(12,3,4,1,9,12,7,9,8);

        Predicate<Integer> integerPredicate = number -> number % 2 == 0;
        Function<Integer, Integer> integerIntegerFunction = number -> number * number;
        Consumer<Integer> println = System.out::println;

        numbers.stream().filter(integerPredicate).map(integerIntegerFunction).forEach(println);

    }
}
