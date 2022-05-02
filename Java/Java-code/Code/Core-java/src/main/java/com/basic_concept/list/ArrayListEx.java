package com.basic_concept.list;

import java.util.ArrayList;

class ArrayListEx {
	public static void main(String[] args) {
		
		ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.ensureCapacity(100);
		System.out.println(list);
		
	}
}