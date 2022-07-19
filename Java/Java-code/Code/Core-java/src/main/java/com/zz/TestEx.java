package com.zz;

class TestEx extends Thread {
	
	public static void main(String[] args) {
		A obj=new A();
		obj.aMethod();
	}
	
}

class A{
	public void aMethod() {
		System.out.println("A class--a method");
		B obj=new B();
		obj.bMethod();
	}
}
class B{
	public void bMethod() {
		System.out.println("B class--b method");
		C obj=new C();
		obj.cMethod();
	}
}
class C{
	public void cMethod() {
		System.out.println("C class--c method");
	}
}