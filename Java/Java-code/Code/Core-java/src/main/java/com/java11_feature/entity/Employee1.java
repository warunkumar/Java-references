package com.java11_feature.entity;

public class Employee1 implements Comparable<Employee1>{
    private String name;
    private int id;
    private float salary;

    public Employee1() {
    }

    public Employee1(String name, int id, float salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id+":"+name+":"+salary;
    }


    @Override
    public int compareTo(Employee1 o) {
        return this.getName().compareTo(o.getName());
    }
}
