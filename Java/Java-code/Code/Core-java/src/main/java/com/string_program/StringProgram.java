package com.string_program;

import java.util.Arrays;
import java.util.List;

public class StringProgram {
    public static void main(String[] args) {
        String input="http://www.google.com/poco/12345";
        String[] s=input.split("http://www.google.com/poco/",1);
        //System.out.println(Arrays.toString(s));
        List<String> list=Arrays.asList(s);
        System.out.println(list);
    }
}
