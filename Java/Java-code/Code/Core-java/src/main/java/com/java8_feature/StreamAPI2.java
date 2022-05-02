package com.java8_feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI2 {
	public static void main(String[] args) {
		
		List<Integer> list1=Arrays.asList(1,2,4,5,3);
		List<Integer> list2=Arrays.asList(10,20,40,50,30);
		List<Integer> list3=Arrays.asList(15,25,45,55,35);
		List<String> list4=Arrays.asList("Warun","Kumar","Upadhyay");

		List<List<Integer>> list5=Arrays.asList(list1,list2,list3);

		//List<Integer> f=list5.stream().flatMap(x->x.stream().sorted(Integer::compareTo)).collect(Collectors.toList());

		list1.sort(Comparator.comparing(Integer::intValue));
		list2.stream().sorted(Comparator.comparing(Integer::intValue));

		System.out.println(list1);


		//System.out.println(f);
		//list1.stream().flatMap(x-> Stream.of(x)).forEach(System.out::println);
		//list4.stream().flatMap(x->Stream.of(x.charAt(2))).forEach(System.out::println);
		
	}
}

