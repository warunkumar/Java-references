package com.basic_code.sorting;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingWithSpecialCharacter {
    public static void main(String[] args) {
        String s="1-3-4-2-9-6-7";
        String s1="1;1,2;2,3;3,4;4,5;5";
        //String[] ch=s.split("-");
        //List<Integer> list=Arrays.asList(ch);
        //System.out.println(list);
        //list.sort();
        List<Integer> list=Arrays.asList(1,2,4,3);
        List<String> list1=Arrays.asList("warun","k","ku","as");

        //Arrays.stream(s.split("-")).mapToInt(x->Integer.parseInt(x)).sorted().forEach(System.out::println);
        //Arrays.stream(s.split("-")).sorted(Comparator.reverseOrder()).
        //list.stream().s
        //System.out.println(l);
        //Comparator com=(o1, o2) -> Integer.v
        //list1.stream().reduce();

        Arrays.stream(s1.split(",")).map(x->x.split(";"));
    }
}
