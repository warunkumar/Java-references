package com.map;

import java.util.HashMap;
import java.util.Map;

class HashMapEx {
	public static void main(String[] args) {
		
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=1;i<=100;i++) {
			map.put(i,i);
		}
		System.out.println(map.size());
		
	}
}