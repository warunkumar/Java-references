package com.java11_feature.program;


import java.util.Comparator;
import java.util.List;

public class Java8Exercise1 {
    public static void main(String[] args) {
        List<String> courses =List.of("java", "spring", "hibernate", "maven", "git" ,"jpa" ,"kafka" ,"servlet", "jsp" , "spring boot");
        List<Integer> numbers= List.of(12,3,4,1,9,12,7,9,8);
        List<Employee> employees=List.of(
                new Employee("a1",20,15.0f),
                new Employee("a2",19,15.1f),
                new Employee("a1",18,15.2f),
                new Employee("a1",17,15.3f),
                new Employee("a1",16,15.4f)
        );
        streamFlatMapEx(courses,numbers,employees);


    }


    // Stream Filter example
    private static void streamFilterEx(List<String> courses, List<Integer> numbers, List<Employee> employees) {
        numbers.stream()
                .filter(number-> number%2==0)
                .forEach(System.out::println);
    }

    // Stream Map example
    private static void streamMapEx(List<String> courses, List<Integer> numbers, List<Employee> employees) {
        numbers.stream()
                .filter(number-> number%2==0)
                .map(number->number*number)
                .forEach(System.out::println);
    }

    // Stream Flat map example
    private static void streamFlatMapEx(List<String> courses, List<Integer> numbers, List<Employee> employees) {
        numbers.stream().map(n-> n*n).forEach(System.out::println);

    }

    // Stream Reduce example
    private static void streamReduceEx(List<String> courses, List<Integer> numbers, List<Employee> employees) {
        int result=numbers.stream()
                .filter(number-> number%2==0)
                .map(number->number*number)
                .reduce(0,Integer::sum);
        System.out.println(result);

    }

    // Stream Sorted example
    private static void streamSortedEx(List<String> courses, List<Integer> numbers, List<Employee> employees) {
        numbers.stream()
                //.filter(number-> number%2==0)
                //.map(number->number*number)
                .sorted(Comparator.comparingInt(Integer::intValue)).forEach(System.out::println);
        //System.out.println(result);

    }


}
