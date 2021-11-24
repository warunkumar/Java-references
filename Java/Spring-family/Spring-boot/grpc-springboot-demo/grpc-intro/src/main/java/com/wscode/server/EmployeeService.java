package com.wscode.server;

import com.wscode.model.Balance;
import com.wscode.model.Employee;
import com.wscode.model.EmployeeCheckRequest;
import com.wscode.model.EmployeeServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

/**
 * @author Warun
 * @createdOn 11-10-2021
 **/
public class EmployeeService extends EmployeeServiceGrpc.EmployeeServiceImplBase {

    /**
     *
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    public void getEmployee(EmployeeCheckRequest request, StreamObserver<Employee> responseObserver) {
        int employeeId=request.getEmployeeId();
        Employee employee=Employee.newBuilder()
                .setEmployeePh(100)
                .build();
        responseObserver.onNext(employee);
        responseObserver.onCompleted();
    }

}
