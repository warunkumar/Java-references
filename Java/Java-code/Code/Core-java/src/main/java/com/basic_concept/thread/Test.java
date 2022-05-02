package com.basic_concept.thread;


public class Test extends Object{
    public static void main(String[] args) {
        Thread t1=new Thread(()->accessResource());
        t1.start();
    }

    public static void accessResource(){
        System.out.println("----");
    }




}



