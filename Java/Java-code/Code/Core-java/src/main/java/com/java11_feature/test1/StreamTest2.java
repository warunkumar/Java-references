package com.java11_feature.test1;




import com.java11_feature.entity.Employee;

import java.util.*;

public class StreamTest2 {

    public static void main(String[] args) {
        Employee e1=new Employee("a",1,100);
        Employee e2=new Employee("b",2,400);
        Employee e3=new Employee("e",3,500);
        Employee e4=new Employee("d",5,300);
        Employee e5=new Employee("c",4,200);

        List<Employee> list=List.of(e1,e2,e3,e4,e5);
        list.stream().sorted(Comparator.comparing(Employee::getId).thenComparing(Employee::getName)).forEach(System.out::println);
    }
}
