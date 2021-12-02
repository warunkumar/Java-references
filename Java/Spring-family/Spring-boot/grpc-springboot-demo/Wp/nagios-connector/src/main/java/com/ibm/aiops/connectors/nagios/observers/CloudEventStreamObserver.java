package com.ibm.aiops.connectors.nagios.observers;

import io.cloudevents.v1.proto.CloudEvent;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Cloud event Stream Observer invoked when Server sends back response
 *
 * @author Naveen Devarajaiah
 * @createdOn 11-08-201
 */
@Component
@Slf4j
public class CloudEventStreamObserver implements StreamObserver<CloudEvent> {

    /**
     * Below methods are Callbacks which are invoked by gRPC Server
     */
    @Override
    public void onNext(CloudEvent cloudEvent) {
        log.info("Cloud Event for source: {} is successfully streamed", cloudEvent.getSource());
    }

    @Override
    public void onError(Throwable t) {
        log.error(t.toString());
    }

    @Override
    public void onCompleted() {
        log.info("Server received data successfully");
    }
}
