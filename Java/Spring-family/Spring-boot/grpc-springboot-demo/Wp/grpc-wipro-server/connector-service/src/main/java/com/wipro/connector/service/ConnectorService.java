package com.wipro.connector.service;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import watson.aiops.connector.ConnectorBridgeGrpc;

/**
 * @author Warun
 * @createdOn 11-10-2021
 **/
@GrpcService
public class ConnectorService extends ConnectorBridgeGrpc.ConnectorBridgeImplBase {

    /**
     *
     * @param responseObserver
     * @return  responseObserver
     */
    @Override
    public StreamObserver<io.cloudevents.v1.proto.CloudEvent> produce(StreamObserver<io.cloudevents.v1.proto.CloudEvent> responseObserver) {

        return new ConnectorStreamingRequest(responseObserver);


    }
}
