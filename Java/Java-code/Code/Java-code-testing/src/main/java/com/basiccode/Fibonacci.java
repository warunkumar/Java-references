package com.basiccode;

public class Fibonacci {
	public static void main(String[] args) {
		int pre=0,last=1,cur=0;
		System.out.println(pre);
		System.out.println(last);
		for(int i=2;i<10;i++) {
			cur=pre+last;
			pre=last;
			last=cur;
			System.out.println(cur);
		}
	}
	
	
}
