package com.java11_feature.program;

import java.util.List;

public class StreamFilterEx2 {

    public static void main(String[] args) {
        List<String> courses =List.of("java", "spring", "hibernate", "maven", "git" ,"jpa" ,"kafka" ,"servlet", "jsp" , "spring boot");

        courses.stream().filter(course->course.length()>=4).forEach(System.out::println);


    }
}
