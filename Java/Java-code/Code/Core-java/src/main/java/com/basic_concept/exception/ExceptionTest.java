package com.basic_concept.exception;

/**
 * Hello world!
 *
 */
public class ExceptionTest 
{
    public static void main( String[] args )
    {
    	String s="This'\''";
    	String pattern=("[a-zA-Z0-9_/-:''\']+");
    	if(s.matches(pattern)) {
    		System.out.println(true);
    	}
    	else {
    		System.out.println(false);
    	}
        //System.out.println( "Hello World!" );
    }
}
