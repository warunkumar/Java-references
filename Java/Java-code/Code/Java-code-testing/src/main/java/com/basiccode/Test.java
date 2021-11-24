package com.basiccode;

public class Test {
	public static void main(String[] args) {
		
		//int i=20,j=23,k=6;
		//int r=beautifulDays(20,23,6);
		//System.out.println(r);
		int c=Runtime.getRuntime().availableProcessors();
		System.out.println(c);
	}
	
	public static int beautifulDays(int i, int j, int k) {
        // Write your code here
        int noOfGoodDays=0;
        for(int a=i;a<=j;a++){
            int reverseNo=0;
            int number=a;
            while(number!=0){
                int remainder=0;
                remainder=number%10;
                number=number/10;
                reverseNo=reverseNo*10+remainder;
                
            }
            if((a-reverseNo)%k==0){
                noOfGoodDays=noOfGoodDays+1;
            }
            
        }
        return noOfGoodDays;
    }
}
