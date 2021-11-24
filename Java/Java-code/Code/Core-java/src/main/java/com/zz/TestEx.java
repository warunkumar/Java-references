package com.zz;

class TestEx extends Thread {
	
	public static void main(String[] args) {
		System.out.println(TestEx.m1());
	}
	public static int m1() {
		try {
			return 1;
		}catch(Exception e) {
			return 2;
		}
		finally {
			return 3;
		}
		//return 4;
	}
}