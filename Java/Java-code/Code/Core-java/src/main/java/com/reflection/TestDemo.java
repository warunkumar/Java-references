package com.reflection;

import java.lang.reflect.Field;

public class TestDemo {
	public static void main(String[] args) throws ClassNotFoundException {
		Class c=Class.forName("com.reflection.Employee");
		Field[] fields=c.getDeclaredFields();
		for(Field f:fields) {
			System.out.println(f.toString());
		}
		System.out.println(c.getCanonicalName());
		
	}
}
