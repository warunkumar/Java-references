package com.java11_feature.program;

import java.util.List;

public class StreamReduceEx {

    public static void main(String[] args) {
        List<String> courses =List.of("java", "spring", "hibernate", "maven", "git" ,"jpa" ,"kafka" ,"servlet", "jsp" , "spring boot");
        printSumOfNumber(List.of(12,3,4,1,9,12));
    }

    public static void printSumOfNumber(List<Integer> integers) {
        int sum;
        //sum=integers.stream().reduce(0, StreamReduceEx::sumOfInteger);
        //sum=integers.stream().reduce(0, (a,b)->a+b);
        //sum=integers.stream().reduce(0,Integer::sum);
        //sum=integers.stream().map(number->number*number).reduce(0, (x,y)->x+y);
        sum=integers.stream().filter(number-> number%2!=0).reduce(0, (x,y)->x+y);

        System.out.println(sum);
    }

    public static int sumOfInteger(int a, int b){
        return a+b;
    }


}
