package com.test1;

import java.util.*;

public class Test {

    public static void main(String[] args){


        //india , Aus, US
        Map<String, String> map=new HashMap<>();
        map.put("India","one");
        map.put("Aus","two");
        map.put("US","three");
        Set<Map.Entry<String,String>> s=map.entrySet();
        Iterator<Map.Entry<String,String>> it=s.iterator();
        while (it.hasNext()){
            Map.Entry<String,String> temp=it.next();
            System.out.println("Key::"+temp.getKey()+"Value::");
        }

        // Select e.id, e.name, d.dep-name from Employee e inner join department inner join add a d on (ei.d=d.id and )
        // select count(e_id) from employee where department="admin" group by gender order by asc
    }


}


