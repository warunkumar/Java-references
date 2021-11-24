package com.wscode.client;

import com.wscode.model.Balance;
import com.wscode.model.BalanceCheckRequest;
import com.wscode.model.BankServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 * @author Warun
 * @createdOn 11-10-2021
 **/
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankClientTest {

    private BankServiceGrpc.BankServiceBlockingStub blockingStub;

    @BeforeAll
    public void setUp(){
        ManagedChannel managedChannel =ManagedChannelBuilder.forAddress("localhost",6565)
                .usePlaintext().build();
        this.blockingStub = BankServiceGrpc.newBlockingStub(managedChannel);

    }

    @Test
    public void balanceTest(){
        BalanceCheckRequest balanceCheckRequest=BalanceCheckRequest.newBuilder()
                .setAccountNumber(5)
                .build();
        Balance balance =this.blockingStub.getBalance(balanceCheckRequest);
        System.out.println(balance.getAmount());
    }
}
