package watson.aiops.connector;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Connector Bridge Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.22.1)",
    comments = "Source: connector.proto")
public final class ConnectorBridgeGrpc {

  private ConnectorBridgeGrpc() {}

  public static final String SERVICE_NAME = "watson.aiops.connector.ConnectorBridge";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.cloudevents.v1.proto.CloudEvent,
      io.cloudevents.v1.proto.CloudEvent> getProduceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Produce",
      requestType = io.cloudevents.v1.proto.CloudEvent.class,
      responseType = io.cloudevents.v1.proto.CloudEvent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<io.cloudevents.v1.proto.CloudEvent,
      io.cloudevents.v1.proto.CloudEvent> getProduceMethod() {
    io.grpc.MethodDescriptor<io.cloudevents.v1.proto.CloudEvent, io.cloudevents.v1.proto.CloudEvent> getProduceMethod;
    if ((getProduceMethod = ConnectorBridgeGrpc.getProduceMethod) == null) {
      synchronized (ConnectorBridgeGrpc.class) {
        if ((getProduceMethod = ConnectorBridgeGrpc.getProduceMethod) == null) {
          ConnectorBridgeGrpc.getProduceMethod = getProduceMethod = 
              io.grpc.MethodDescriptor.<io.cloudevents.v1.proto.CloudEvent, io.cloudevents.v1.proto.CloudEvent>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "watson.aiops.connector.ConnectorBridge", "Produce"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.cloudevents.v1.proto.CloudEvent.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.cloudevents.v1.proto.CloudEvent.getDefaultInstance()))
                  .setSchemaDescriptor(new ConnectorBridgeMethodDescriptorSupplier("Produce"))
                  .build();
          }
        }
     }
     return getProduceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.cloudevents.v1.proto.CloudEvent,
      io.cloudevents.v1.proto.CloudEvent> getConsumeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Consume",
      requestType = io.cloudevents.v1.proto.CloudEvent.class,
      responseType = io.cloudevents.v1.proto.CloudEvent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<io.cloudevents.v1.proto.CloudEvent,
      io.cloudevents.v1.proto.CloudEvent> getConsumeMethod() {
    io.grpc.MethodDescriptor<io.cloudevents.v1.proto.CloudEvent, io.cloudevents.v1.proto.CloudEvent> getConsumeMethod;
    if ((getConsumeMethod = ConnectorBridgeGrpc.getConsumeMethod) == null) {
      synchronized (ConnectorBridgeGrpc.class) {
        if ((getConsumeMethod = ConnectorBridgeGrpc.getConsumeMethod) == null) {
          ConnectorBridgeGrpc.getConsumeMethod = getConsumeMethod = 
              io.grpc.MethodDescriptor.<io.cloudevents.v1.proto.CloudEvent, io.cloudevents.v1.proto.CloudEvent>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "watson.aiops.connector.ConnectorBridge", "Consume"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.cloudevents.v1.proto.CloudEvent.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.cloudevents.v1.proto.CloudEvent.getDefaultInstance()))
                  .setSchemaDescriptor(new ConnectorBridgeMethodDescriptorSupplier("Consume"))
                  .build();
          }
        }
     }
     return getConsumeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.cloudevents.v1.proto.CloudEvent,
      io.cloudevents.v1.proto.CloudEvent> getConfigurationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Configuration",
      requestType = io.cloudevents.v1.proto.CloudEvent.class,
      responseType = io.cloudevents.v1.proto.CloudEvent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<io.cloudevents.v1.proto.CloudEvent,
      io.cloudevents.v1.proto.CloudEvent> getConfigurationMethod() {
    io.grpc.MethodDescriptor<io.cloudevents.v1.proto.CloudEvent, io.cloudevents.v1.proto.CloudEvent> getConfigurationMethod;
    if ((getConfigurationMethod = ConnectorBridgeGrpc.getConfigurationMethod) == null) {
      synchronized (ConnectorBridgeGrpc.class) {
        if ((getConfigurationMethod = ConnectorBridgeGrpc.getConfigurationMethod) == null) {
          ConnectorBridgeGrpc.getConfigurationMethod = getConfigurationMethod = 
              io.grpc.MethodDescriptor.<io.cloudevents.v1.proto.CloudEvent, io.cloudevents.v1.proto.CloudEvent>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "watson.aiops.connector.ConnectorBridge", "Configuration"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.cloudevents.v1.proto.CloudEvent.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.cloudevents.v1.proto.CloudEvent.getDefaultInstance()))
                  .setSchemaDescriptor(new ConnectorBridgeMethodDescriptorSupplier("Configuration"))
                  .build();
          }
        }
     }
     return getConfigurationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<watson.aiops.connector.ConnectorStatus,
      io.cloudevents.v1.proto.CloudEvent> getStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Status",
      requestType = watson.aiops.connector.ConnectorStatus.class,
      responseType = io.cloudevents.v1.proto.CloudEvent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<watson.aiops.connector.ConnectorStatus,
      io.cloudevents.v1.proto.CloudEvent> getStatusMethod() {
    io.grpc.MethodDescriptor<watson.aiops.connector.ConnectorStatus, io.cloudevents.v1.proto.CloudEvent> getStatusMethod;
    if ((getStatusMethod = ConnectorBridgeGrpc.getStatusMethod) == null) {
      synchronized (ConnectorBridgeGrpc.class) {
        if ((getStatusMethod = ConnectorBridgeGrpc.getStatusMethod) == null) {
          ConnectorBridgeGrpc.getStatusMethod = getStatusMethod = 
              io.grpc.MethodDescriptor.<watson.aiops.connector.ConnectorStatus, io.cloudevents.v1.proto.CloudEvent>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "watson.aiops.connector.ConnectorBridge", "Status"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  watson.aiops.connector.ConnectorStatus.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.cloudevents.v1.proto.CloudEvent.getDefaultInstance()))
                  .setSchemaDescriptor(new ConnectorBridgeMethodDescriptorSupplier("Status"))
                  .build();
          }
        }
     }
     return getStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ConnectorBridgeStub newStub(io.grpc.Channel channel) {
    return new ConnectorBridgeStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConnectorBridgeBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ConnectorBridgeBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ConnectorBridgeFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ConnectorBridgeFutureStub(channel);
  }

  /**
   * <pre>
   * Connector Bridge Service
   * </pre>
   */
  public static abstract class ConnectorBridgeImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<io.cloudevents.v1.proto.CloudEvent> produce(
        io.grpc.stub.StreamObserver<io.cloudevents.v1.proto.CloudEvent> responseObserver) {
      return asyncUnimplementedStreamingCall(getProduceMethod(), responseObserver);
    }

    /**
     */
    public void consume(io.cloudevents.v1.proto.CloudEvent request,
        io.grpc.stub.StreamObserver<io.cloudevents.v1.proto.CloudEvent> responseObserver) {
      asyncUnimplementedUnaryCall(getConsumeMethod(), responseObserver);
    }

    /**
     */
    public void configuration(io.cloudevents.v1.proto.CloudEvent request,
        io.grpc.stub.StreamObserver<io.cloudevents.v1.proto.CloudEvent> responseObserver) {
      asyncUnimplementedUnaryCall(getConfigurationMethod(), responseObserver);
    }

    /**
     */
    public void status(watson.aiops.connector.ConnectorStatus request,
        io.grpc.stub.StreamObserver<io.cloudevents.v1.proto.CloudEvent> responseObserver) {
      asyncUnimplementedUnaryCall(getStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getProduceMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                io.cloudevents.v1.proto.CloudEvent,
                io.cloudevents.v1.proto.CloudEvent>(
                  this, METHODID_PRODUCE)))
          .addMethod(
            getConsumeMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                io.cloudevents.v1.proto.CloudEvent,
                io.cloudevents.v1.proto.CloudEvent>(
                  this, METHODID_CONSUME)))
          .addMethod(
            getConfigurationMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                io.cloudevents.v1.proto.CloudEvent,
                io.cloudevents.v1.proto.CloudEvent>(
                  this, METHODID_CONFIGURATION)))
          .addMethod(
            getStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                watson.aiops.connector.ConnectorStatus,
                io.cloudevents.v1.proto.CloudEvent>(
                  this, METHODID_STATUS)))
          .build();
    }
  }

  /**
   * <pre>
   * Connector Bridge Service
   * </pre>
   */
  public static final class ConnectorBridgeStub extends io.grpc.stub.AbstractStub<ConnectorBridgeStub> {
    private ConnectorBridgeStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConnectorBridgeStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConnectorBridgeStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConnectorBridgeStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.cloudevents.v1.proto.CloudEvent> produce(
        io.grpc.stub.StreamObserver<io.cloudevents.v1.proto.CloudEvent> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getProduceMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void consume(io.cloudevents.v1.proto.CloudEvent request,
        io.grpc.stub.StreamObserver<io.cloudevents.v1.proto.CloudEvent> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getConsumeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void configuration(io.cloudevents.v1.proto.CloudEvent request,
        io.grpc.stub.StreamObserver<io.cloudevents.v1.proto.CloudEvent> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getConfigurationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void status(watson.aiops.connector.ConnectorStatus request,
        io.grpc.stub.StreamObserver<io.cloudevents.v1.proto.CloudEvent> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Connector Bridge Service
   * </pre>
   */
  public static final class ConnectorBridgeBlockingStub extends io.grpc.stub.AbstractStub<ConnectorBridgeBlockingStub> {
    private ConnectorBridgeBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConnectorBridgeBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConnectorBridgeBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConnectorBridgeBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<io.cloudevents.v1.proto.CloudEvent> consume(
        io.cloudevents.v1.proto.CloudEvent request) {
      return blockingServerStreamingCall(
          getChannel(), getConsumeMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<io.cloudevents.v1.proto.CloudEvent> configuration(
        io.cloudevents.v1.proto.CloudEvent request) {
      return blockingServerStreamingCall(
          getChannel(), getConfigurationMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.cloudevents.v1.proto.CloudEvent status(watson.aiops.connector.ConnectorStatus request) {
      return blockingUnaryCall(
          getChannel(), getStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Connector Bridge Service
   * </pre>
   */
  public static final class ConnectorBridgeFutureStub extends io.grpc.stub.AbstractStub<ConnectorBridgeFutureStub> {
    private ConnectorBridgeFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConnectorBridgeFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConnectorBridgeFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConnectorBridgeFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.cloudevents.v1.proto.CloudEvent> status(
        watson.aiops.connector.ConnectorStatus request) {
      return futureUnaryCall(
          getChannel().newCall(getStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CONSUME = 0;
  private static final int METHODID_CONFIGURATION = 1;
  private static final int METHODID_STATUS = 2;
  private static final int METHODID_PRODUCE = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ConnectorBridgeImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ConnectorBridgeImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONSUME:
          serviceImpl.consume((io.cloudevents.v1.proto.CloudEvent) request,
              (io.grpc.stub.StreamObserver<io.cloudevents.v1.proto.CloudEvent>) responseObserver);
          break;
        case METHODID_CONFIGURATION:
          serviceImpl.configuration((io.cloudevents.v1.proto.CloudEvent) request,
              (io.grpc.stub.StreamObserver<io.cloudevents.v1.proto.CloudEvent>) responseObserver);
          break;
        case METHODID_STATUS:
          serviceImpl.status((watson.aiops.connector.ConnectorStatus) request,
              (io.grpc.stub.StreamObserver<io.cloudevents.v1.proto.CloudEvent>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PRODUCE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.produce(
              (io.grpc.stub.StreamObserver<io.cloudevents.v1.proto.CloudEvent>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ConnectorBridgeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConnectorBridgeBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return watson.aiops.connector.Connector.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ConnectorBridge");
    }
  }

  private static final class ConnectorBridgeFileDescriptorSupplier
      extends ConnectorBridgeBaseDescriptorSupplier {
    ConnectorBridgeFileDescriptorSupplier() {}
  }

  private static final class ConnectorBridgeMethodDescriptorSupplier
      extends ConnectorBridgeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ConnectorBridgeMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ConnectorBridgeGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ConnectorBridgeFileDescriptorSupplier())
              .addMethod(getProduceMethod())
              .addMethod(getConsumeMethod())
              .addMethod(getConfigurationMethod())
              .addMethod(getStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
