package com.wscode.server;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Warun
 * @createdOn 11-10-2021
 **/
public class AccountDatabase {
    private static final Map<Integer,Integer> map= IntStream.rangeClosed(1,10)
            .boxed()
            .collect(Collectors.toMap(Function.identity(),v->v*10));

    public static int getBalance(int accountId){
        return map.get(accountId);
    }

    public static int addBalance(int accountId, int amount){
        return map.computeIfPresent(accountId, (k,v)-> v+amount);
    }

    public static int deductBalance(int accountId, int amount){
        return map.computeIfPresent(accountId, (k,v)-> v-amount);
    }
}
