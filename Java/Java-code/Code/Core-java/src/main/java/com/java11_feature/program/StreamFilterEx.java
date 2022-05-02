package com.java11_feature.program;

import java.util.List;

/**
 * @author warun
 * @createdOn 12/3/2021
 */

public class StreamFilterEx {

    public static void main(String[] args) {
        List<String> courses =List.of("java", "spring", "hibernate", "maven", "git" ,"jpa" ,"kafka" ,"servlet", "jsp" , "spring boot");
        //printEvenNumberInTheList(List.of(12,3,4,1,9,12));

        printAllCoursesWithSpecificString(courses);
    }

    public static void printAllCoursesWithSpecificString(List<String> courses){
        courses.stream().filter(course-> course.contains("spring")).forEach(System.out::println);

    }


    public static boolean isEven(int number){
        return number % 2==0;
    }

    public static void printAllNumberInTheList(List<Integer> numbers){
        //numbers.stream().forEach(MethodReferenceEx::printTheNumber);

        numbers.stream().forEach(System.out::println);
    }
    public static void printEvenNumberInTheList(List<Integer> numbers){

        /*numbers.stream().filter(StreamFilterEx::isEven )
                .forEach(System.out::println);*/
        // Logic for even numbers
        //numbers.stream().filter(x->x%2==0).forEach(System.out::println);
        // Logic to check the odd numbers
        numbers.stream().filter(x-> x%2 !=0).forEach(System.out::println);
    }
}
