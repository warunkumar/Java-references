package com.wscode.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @author Warun
 * @createdOn 11-10-2021
 **/
public class GrpcServerEmployee {
    /**
     *
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(6565)
                .addService(new EmployeeService())
                .build();

        server.start();
        server.awaitTermination();

    }
}
