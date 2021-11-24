package com.wscode.server;

import com.wscode.model.Balance;
import com.wscode.model.BalanceCheckRequest;
import com.wscode.model.BankServiceGrpc;
import io.grpc.stub.StreamObserver;

public class BankService extends BankServiceGrpc.BankServiceImplBase {

    @Override
    public void getBalance(BalanceCheckRequest request, StreamObserver<Balance> responseObserver) {
        int accountNumber=request.getAccountNumber();
        Balance balance=Balance.newBuilder()
                .setAmount(AccountDatabase.getBalance(accountNumber))
                .build();
        responseObserver.onNext(balance);
        responseObserver.onCompleted();
    }
}
