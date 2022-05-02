package com.basic_code;

public class ReverseNumberTest {
	public static void main(String[] args) {
		int number=123;
		
		int reverse=0;
		
		while(number!=0){
			int remainder=0;
			remainder=number%10;
			number=number/10;
			reverse=reverse*10+remainder;
			
		}
		
		System.out.println(reverse);
		
	}
}
