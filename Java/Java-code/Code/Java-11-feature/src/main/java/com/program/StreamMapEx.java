package com.program;

import java.util.List;

public class StreamMapEx {

    public static void main(String[] args) {
        List<String> courses =List.of("java", "spring", "hibernate", "maven", "git" ,"jpa" ,"kafka" ,"servlet", "jsp" , "spring boot");
        printSquareOfNumber(List.of(12,3,4,1,9,12));
    }

    public static void printSquareOfNumber(List<Integer> number){
        number.stream().map(n-> "Number "+ n*n).forEach(System.out::println);

    }
}
