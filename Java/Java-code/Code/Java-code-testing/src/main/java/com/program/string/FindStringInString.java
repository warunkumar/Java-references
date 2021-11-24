package com.program.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FindStringInString {
	public static void main(String[] args) {
		List<Employee> list=new ArrayList<Employee>();
		Employee e1=new Employee(1,"a","ibmaacom");
		Employee e2=new Employee(2,"b","ibmaacom");
		Employee e3=new Employee(3,"c","aibmaacom");
		Employee e4=new Employee(4,"d","hjhjhjibmaacom");
		Employee e5=new Employee(5,"e","ibmaacom");
		
		list=Arrays.asList(e1,e2,e3,e4,e5);
		List<String> l=list.stream().filter(o->(o.getEmailId().startsWith("ibm"))==true).map(o->o.getEmailId()).collect(Collectors.toList());
		
		System.out.println(l);
	}
	
}

