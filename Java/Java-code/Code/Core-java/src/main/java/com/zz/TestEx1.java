package com.zz;

public class TestEx1 {
	public static void main(String[] args) {
		String s="warun";
		Emp e=new Emp();
		if("warun".equalsIgnoreCase(e.name)) {
			System.out.println("1");
		}else if("kumar"==e.name) {
			System.out.println("2");
		}else {
			System.out.println("hahahah");
		}
	}
}

class Emp{
	int id;
	String name="warun";
	
}
