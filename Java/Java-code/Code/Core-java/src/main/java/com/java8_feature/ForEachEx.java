package com.java8_feature;

import java.util.*;

public class ForEachEx {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		Map<String,String> map=new HashMap<String,String>();
		map.put("1", "a");
		map.put("2", "b");
		map.put("3", "c");
		map.put("4", "d");
		
		list.forEach(System.out::println);
		//System.out.println(map);
		//map.forEach(System.out::println);
		//list.forEach((s)->System.out.println(s));
		//map.forEach((k,v)->System.out.println(k));
		//list.stream().fo


		
	
		
	}
}
