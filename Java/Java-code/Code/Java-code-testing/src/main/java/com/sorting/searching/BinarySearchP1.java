package com.sorting.searching;

public class BinarySearchP1 {
	public static void main(String[] args) {
		int array[] = { 10 };
		int searchItem=10;
		int[] result=bubbleSearch(array,searchItem);
		
	}

	public static int[] bubbleSearch(int array[], int searchItem) {
		int length=array.length;
		int first=0;
		int last=length-1;
		int middle=(last + first)/2;  
		while(first<=last) {
			if(array[middle]<searchItem) {
				first=middle+1;
			}else if(array[middle]==searchItem) {
				System.out.println("item found "+middle);
				break;
			}else {
				last=middle-1;
			}
			 middle = (first + last)/2; 
			
		}
		
		
		return array;

	}
}
