package com.list;

import java.util.ArrayList;
import java.util.List;

class ArrayListEx {
	public static void main(String[] args) {
		
		ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.ensureCapacity(100);
		System.out.println(list);
		
	}
}