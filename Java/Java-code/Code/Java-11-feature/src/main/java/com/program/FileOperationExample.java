package com.program;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class FileOperationExample {
    public static void main(String[] args) throws IOException {
        String fileName = "appInfo.txt";
        Stream<String> fileStream=Files.lines(Paths.get(fileName));
        //printAllFileLines(fileStream);
        printWordWise(fileStream);

    }
    public static void printAllFileLines(Stream<String> fileStream){
        fileStream.forEach(System.out::println);
    }

    public static void printWordWise(Stream<String> fileStream){
        //fileStream.map(str->str.split(" ")).forEach(System.out::println);
        //fileStream.map(str->str.split(" ")).flatMap(Arrays::stream).forEach(System.out::println);
        //fileStream.forEach(System.out::println);
        fileStream.map(str->str.split(" ")).flatMap(Arrays::stream).forEach(System.out::println);
    }
}
