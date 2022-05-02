package com.java11_feature.program;

import java.util.List;

/**
 * @author warun
 * @createdOn 12/3/2021
 */

public class StructureApproachEx {
    public static void main(String[] args) {
        printEvenNumberInTheList(List.of(12,3,4,1,9,12));


    }

    public static void printAllNumberInTheList(List<Integer> numbers){
        for (int n:numbers){
            System.out.println(n);
        }
    }

    public static void printEvenNumberInTheList(List<Integer> numbers){
        for (int n:numbers){
            if (n % 2 == 0){
                System.out.println("Even no:: "+n);
            }else {
                System.out.println("Odd no:: "+n);
            }

        }
    }
}
