package com.basic_code;

public class LinearSearchP1 {
	public static void main(String[] args) {
		int array[] = { 10, 20, 30, 25, 15 };
		int searchItem=30;
		boolean result=linearSearch(array,searchItem);
		if(result==false) {
			System.out.println("Item no found");
		}
	}

	public static boolean linearSearch(int array[], int searchItem) {
		for(int i=0;i<array.length-1;i++) {
			if(array[i]==searchItem) {
				System.out.println("Item found at index "+i);
				return true;
			}
		}
		return false;

	}
}
