package com.java11_feature.program;

import java.util.List;
import java.util.stream.Collectors;


public class StreamTerminalOperationEx {

    public static void main(String[] args) {
        List<String> courses =List.of("java", "spring", "hibernate", "maven", "git" ,"jpa" ,"kafka" ,"servlet", "jsp" , "spring boot");
        List<Integer> numbers= List.of(12,3,4,1,9,12,7,9,8);
        collectorEx(courses);

    }

    public static void collectorEx(List<String> courses){
        List<String> newList=courses.stream().filter(course-> course.contains("spring")).collect(Collectors.toList());
        System.out.println(newList);
    }

}
