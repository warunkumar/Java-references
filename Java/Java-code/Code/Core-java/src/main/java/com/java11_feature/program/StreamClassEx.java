package com.java11_feature.program;

import java.util.stream.Stream;

public class StreamClassEx {
    public static void main(String[] args) {
        Stream.of(1,2,3,4).forEach(System.out::println);
    }
}
