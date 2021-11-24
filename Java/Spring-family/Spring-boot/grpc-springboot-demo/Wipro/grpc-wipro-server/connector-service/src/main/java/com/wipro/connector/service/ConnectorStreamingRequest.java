package com.wipro.connector.service;

import io.cloudevents.v1.proto.CloudEvent;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Warun
 * @createdOn 20-10-2021
 **/
public class ConnectorStreamingRequest implements StreamObserver<io.cloudevents.v1.proto.CloudEvent> {

    Logger logger = LoggerFactory.getLogger(ConnectorStreamingRequest.class);

    private StreamObserver<io.cloudevents.v1.proto.CloudEvent> cloudeventsStreamResObserver;

    CloudEvent cloudEvent;
    private String streamSorce;

    public ConnectorStreamingRequest(StreamObserver<io.cloudevents.v1.proto.CloudEvent> cloudeventsStreamResObserver){
        this.cloudeventsStreamResObserver=cloudeventsStreamResObserver;
    }

    /**
     *
     * @param cloudEvent
     * onNext
     */
    @Override
    public void onNext(CloudEvent cloudEvent) {
        this.cloudEvent=cloudEvent;
        streamSorce=cloudEvent.getSource();
        CloudEvent.CloudEventAttributeValue event = cloudEvent.getAttributesOrThrow("event");
        String eventData=event.getCeString();
        logger.info("Data::::::"+eventData);

    }

    @Override
    public void onError(Throwable throwable) {

    }

    /**
     * onCompleted()
     */
    @Override
    public void onCompleted() {
        CloudEvent cloudEventResponse=cloudEvent.newBuilder().setSource("Nagios").build();
        this.cloudeventsStreamResObserver.onNext(cloudEventResponse);
        this.cloudeventsStreamResObserver.onCompleted();
    }
}
