package com.program;

import java.util.List;

public class MethodReferenceAdvanceEx {
    public static void main(String[] args) {
        printAllNumberInTheList(List.of(12,3,4,1,9,12));

    }
    public static void printTheNumber(int number){
        System.out.println(number);
    }

    public static void printAllNumberInTheList(List<Integer> numbers){
        //numbers.stream().forEach(MethodReferenceEx::printTheNumber);

        numbers.stream().forEach(System.out::println);
    }
}
