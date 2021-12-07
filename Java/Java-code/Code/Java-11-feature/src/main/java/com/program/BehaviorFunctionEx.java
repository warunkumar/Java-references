package com.program;

import java.util.List;
import java.util.function.*;


public class BehaviorFunctionEx {

    public static void main(String[] args) {
        List<String> courses =List.of("java", "spring", "hibernate", "maven", "git" ,"jpa" ,"kafka" ,"servlet", "jsp" , "spring boot");
        List<Integer> numbers= List.of(12,3,4,1,9,12,7,9,8);

        Predicate<Integer> integerPredicate = number -> number % 2 == 0;
        Function<Integer,Integer> function= a-> a * a;
        Consumer<Integer> consumer= input-> System.out.println(input);
        BinaryOperator<Integer> binaryOperator= (a,b)->a+b;
        UnaryOperator<Integer> unaryOperator=(a)->a+a;
        Supplier<Integer> supplier=()->{
            return 2;
        };
        BiPredicate<Integer,Integer> biPredicate=(a,b)->true;
        BiFunction<Integer,String,Integer> biFunction=(a,b)->2;

        System.out.println(supplier.get());

        //getaVoid(numbers, integerPredicate);

    }

    private static void getaVoid(List<Integer> numbers, Predicate<Integer> integerPredicate) {
        numbers.stream().filter(integerPredicate).map(number -> number * number).forEach(System.out::println);
    }
}
