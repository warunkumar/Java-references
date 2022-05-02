package com.java11_feature.test1;

import java.util.List;

public class StreamTest1 {
    public static void main(String[] args) {
        List<Integer> output=null;
        List<Integer> inputList=null;

        inputList=List.of(10,8,7,5,6,1,2,4,3,9,11,12,99);


        //output=inputList.stream().filter(x->(x%2)==0).sorted().collect(Collectors.toList());
        //inputList.stream().map(s->s+"").filter(x->x.startsWith("1")).forEach(System.out::println);
        //inputList.stream().findFirst().ifPresent(System.out::println);
        inputList.stream().max(Integer::compare).ifPresent(System.out::println);

        System.out.println(inputList.stream().count());

        //System.out.println(output);

    }
}
