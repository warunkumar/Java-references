package com.program;

import java.util.Comparator;
import java.util.List;

public class StreamAllMethodEx {

    public static void main(String[] args) {
        List<String> courses =List.of("java", "spring", "hibernate", "maven", "git" ,"jpa" ,"kafka" ,"servlet", "jsp" , "spring boot");
        List<Integer> numbers= List.of(12,3,4,1,9,12,7,9,8);

        /* Distinct Example */
        //numbers.stream().distinct().forEach(System.out::println);

        /* Sorted Example */
        //numbers.stream().sorted().forEach(System.out::println);
        //numbers.stream().distinct().sorted().forEach(System.out::println);

        /* Sorted Example  By Comparator*/
        sortedStringByComparator(courses);
    }

    public static void sortedNumberByComparator(List<Integer> numbers){
        //numbers.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
        //numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        numbers.stream().sorted((o1, o2) -> o1-o2).forEach(System.out::println);
    }
    public static void sortedStringByComparator(List<String> vars){
        //numbers.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
        //numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        vars.stream().sorted((o1, o2) -> o1.length()-o2.length()).forEach(System.out::println);
    }

}
