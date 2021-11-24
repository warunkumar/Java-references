package com.program.string;

public class ReverseStringRecursionExample {

	// recursive function to reverse a string
	void reverseString(String string) {
		if ((string == null) || (string.length() <= 1))
			System.out.println(string);
		else {
			System.out.print(string.charAt(string.length() - 1));
			reverseString(string.substring(0, string.length() - 1));
		}
	}

	public static void main(String[] args) {
		// string to be reversed
		String str = "abc";
		ReverseStringRecursionExample rs = new ReverseStringRecursionExample();
		// invoking the recursive function and passing the string to be reversed
		rs.reverseString(str);
	}
}
