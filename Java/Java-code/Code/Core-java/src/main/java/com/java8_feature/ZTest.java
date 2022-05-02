package com.java8_feature;

import java.util.*;
import com.java8_feature.Employee1;
/**
 * @author warun
 * @createdOn 12/3/2021
 */

public class ZTest {
    public static void main(String[] args) {
        /*Employee1 e1=new Employee1(1);
        Employee1 e2=new Employee1(2);
        Employee1 e3=new Employee1(1);

        Map<Employee1,Integer> map=new HashMap<>();
        map.put(e1,1);
        map.put(e2,2);
        map.put(e3,3);*/

        //List <Integer> list = Arrays.asList(20, 50, 99, 12, 94);
        List <String> list = Arrays.asList("F", "c", "A", "e", "d");
        //listOfIntegers.stream().mapToInt(x->x.intValue()).average().ifPresent(System.out::println);
        //list.stream().sorted(Integer::compareTo).forEach(System.out::println);
        list.stream().sorted(String::compareTo).forEach(System.out::println);
        //System.out.println(list);
    }
}
