package com.java8_feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
	public static void main(String[] args) {
		
		List<String> nameList=new ArrayList<String>();
		List<Employee> list=new ArrayList<Employee>();
		Employee e1=new Employee(1,"warun1",1234567891,100.10f);
		Employee e2=new Employee(2,"warun5",1234567892,100.40f);
		Employee e3=new Employee(4,"warun4",1234567893,100.20f);
		Employee e4=new Employee(3,"warun3",1234567894,100.30f);
		Employee e5=new Employee(4,"warun5",1234567895,100.50f);
		list=Arrays.asList(e1,e2,e3,e4,e5);
		//nameList=list.stream().map(e->e.getName()).filter(e->e.g).collect(Collectors.toList());
		//nameList=list.stream().filter(e->e.getId()<=31).map(e->e.getName()).collect(Collectors.toList());
		
		//List<Employee> l=list.stream().sorted().collect(Collectors.toList());
		//List<Employee> l=list.stream().sorted((o1,o2)->o1.getId()-o2.getId()).collect(Collectors.toList());
		
		//System.out.println(l);
		/*********************************/

		List<String> list1=Arrays.asList("112a","asv","123","+12345","+112-3451-9999");
		//list1.stream().flatMap(x-> Stream.of(x.charAt(1))).forEach(System.out::println);
		//list1.stream().map(x->x+"warun").forEach(System.out::println);
		list1.stream().filter(x->x.startsWith("+1")&& x.contains("-") && x.length()>10).forEach(System.out::println);
		
	}
}

