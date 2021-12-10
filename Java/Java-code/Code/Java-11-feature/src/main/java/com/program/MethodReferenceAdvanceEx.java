package com.program;

import java.util.List;
import java.util.function.Supplier;

public class MethodReferenceAdvanceEx {
    public static void main(String[] args) {
        List<String> courses =List.of("java", "spring", "hibernate", "maven", "git" ,"jpa" ,"kafka" ,"servlet", "jsp" , "spring boot");
        List<Integer> numbers= List.of(12,3,4,1,9,12,7,9,8);

        printAllNumberInTheList(courses);

    }

    public static void printAllNumberInTheList(List<String> vars){
        //numbers.stream().forEach(MethodReferenceEx::printTheNumber);
        //vars.stream().map(var->var.toUpperCase()).forEach(System.out::println);
        vars.stream().map(String::toUpperCase).forEach(MethodReferenceAdvanceEx::print);
        Supplier<MethodReferenceAdvanceEx> supplier=MethodReferenceAdvanceEx::new;
        String s=new String();
    }
    public static void print(String str){
        System.out.println(str);
    }
}
