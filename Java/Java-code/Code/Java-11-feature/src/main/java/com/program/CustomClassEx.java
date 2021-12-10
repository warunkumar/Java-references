package com.program;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomClassEx {
    public static void main(String[] args) {
        List<Course> courses= List.of(
                new Course("Spring","framework",98,1000),
                new Course("Spring boot","framework",98,3000),
                new Course("api","framework",98,2000),
                new Course("Micro Services","microservices",99,4000),
                new Course("AWS","cloud",99,9000),
                new Course("Docker","microservices",91,7000),
                new Course("fullstack","fullstack",90,6000)


        );
        // allMatch, nonMatch, anyMatch
        boolean result1=courses.stream().allMatch(course->course.getReviewScore()>=90);
        Predicate<Course> coursePredicate = course -> course.getReviewScore() >= 90;
        courses.stream().allMatch(coursePredicate);
        Comparator<Course> courseComparator1=Comparator.comparing(Course::getReviewScore);
        //Comparator<Course> courseComparator2=(o1, o2) -> o1.getReviewScore()- o2.getReviewScore();
        Comparator<Course> courseComparator2=(o1, o2) -> o1.getReviewScore();

        Comparator<Course> courseComparator3=Comparator.comparing(Course::getName).thenComparing(Course::getCategory);

        //System.out.println(courses.stream().sorted(courseComparator1).collect(Collectors.toList()));
        //System.out.println(courses.stream().sorted(courseComparator2).collect(Collectors.toList()));
        //System.out.println(result1);

        /* --------------------------------*/
        // limit,

        //System.out.println(courses.stream().sorted(courseComparator1).limit(5).collect(Collectors.toList()));
        //System.out.println(courses.stream().sorted(courseComparator1)..collect(Collectors.toList()));

        /* --------------------------------*/
        // Min, Max

        System.out.println(courses.stream().min(courseComparator1));
        System.out.println(courses.stream().max(courseComparator1));

        /* --------------------------------*/
        // average,


    }
}
