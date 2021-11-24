package com.exception;

import java.io.IOException;

public class TestException2 {

	public static void main(String[] args) {
		try {
			foo();
		}catch(NullPointerException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void foo() {
		
	}
}