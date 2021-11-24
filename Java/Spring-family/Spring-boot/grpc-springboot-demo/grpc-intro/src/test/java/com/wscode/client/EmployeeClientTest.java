package com.wscode.client;

import com.wscode.model.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;

/**
 * @author Warun
 * @createdOn 11-10-2021
 **/
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EmployeeClientTest {

    private EmployeeServiceGrpc.EmployeeServiceBlockingStub blockingStub;

    /**
     *
     */
    @BeforeAll
    public void setUp(){
        ManagedChannel managedChannel =ManagedChannelBuilder.forAddress("localhost",6565)
                .usePlaintext().build();
        this.blockingStub = EmployeeServiceGrpc.newBlockingStub(managedChannel);

    }

    /**
     *
     */
    @Test
    public void employeeTest(){
        EmployeeCheckRequest employeeCheckRequest= EmployeeCheckRequest.newBuilder()
                .setEmployeeId(1)
                .build();
        Employee employee =this.blockingStub.getEmployee(employeeCheckRequest);
        System.out.println(employee.getEmployeePh());
    }
}
