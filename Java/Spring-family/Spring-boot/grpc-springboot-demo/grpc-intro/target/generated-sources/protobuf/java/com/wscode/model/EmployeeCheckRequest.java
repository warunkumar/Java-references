// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: employee-service.proto

package com.wscode.model;

/**
 * Protobuf type {@code EmployeeCheckRequest}
 */
public  final class EmployeeCheckRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:EmployeeCheckRequest)
    EmployeeCheckRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use EmployeeCheckRequest.newBuilder() to construct.
  private EmployeeCheckRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private EmployeeCheckRequest() {
    employeeId_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private EmployeeCheckRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            employeeId_ = input.readInt32();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.wscode.model.EmployeeServiceOuterClass.internal_static_EmployeeCheckRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.wscode.model.EmployeeServiceOuterClass.internal_static_EmployeeCheckRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.wscode.model.EmployeeCheckRequest.class, com.wscode.model.EmployeeCheckRequest.Builder.class);
  }

  public static final int EMPLOYEE_ID_FIELD_NUMBER = 1;
  private int employeeId_;
  /**
   * <code>int32 employee_id = 1;</code>
   */
  public int getEmployeeId() {
    return employeeId_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (employeeId_ != 0) {
      output.writeInt32(1, employeeId_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (employeeId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, employeeId_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.wscode.model.EmployeeCheckRequest)) {
      return super.equals(obj);
    }
    com.wscode.model.EmployeeCheckRequest other = (com.wscode.model.EmployeeCheckRequest) obj;

    boolean result = true;
    result = result && (getEmployeeId()
        == other.getEmployeeId());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + EMPLOYEE_ID_FIELD_NUMBER;
    hash = (53 * hash) + getEmployeeId();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.wscode.model.EmployeeCheckRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.wscode.model.EmployeeCheckRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.wscode.model.EmployeeCheckRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.wscode.model.EmployeeCheckRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.wscode.model.EmployeeCheckRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.wscode.model.EmployeeCheckRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.wscode.model.EmployeeCheckRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.wscode.model.EmployeeCheckRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.wscode.model.EmployeeCheckRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.wscode.model.EmployeeCheckRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.wscode.model.EmployeeCheckRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.wscode.model.EmployeeCheckRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.wscode.model.EmployeeCheckRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code EmployeeCheckRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:EmployeeCheckRequest)
      com.wscode.model.EmployeeCheckRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.wscode.model.EmployeeServiceOuterClass.internal_static_EmployeeCheckRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.wscode.model.EmployeeServiceOuterClass.internal_static_EmployeeCheckRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.wscode.model.EmployeeCheckRequest.class, com.wscode.model.EmployeeCheckRequest.Builder.class);
    }

    // Construct using com.wscode.model.EmployeeCheckRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      employeeId_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.wscode.model.EmployeeServiceOuterClass.internal_static_EmployeeCheckRequest_descriptor;
    }

    @java.lang.Override
    public com.wscode.model.EmployeeCheckRequest getDefaultInstanceForType() {
      return com.wscode.model.EmployeeCheckRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.wscode.model.EmployeeCheckRequest build() {
      com.wscode.model.EmployeeCheckRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.wscode.model.EmployeeCheckRequest buildPartial() {
      com.wscode.model.EmployeeCheckRequest result = new com.wscode.model.EmployeeCheckRequest(this);
      result.employeeId_ = employeeId_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.wscode.model.EmployeeCheckRequest) {
        return mergeFrom((com.wscode.model.EmployeeCheckRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.wscode.model.EmployeeCheckRequest other) {
      if (other == com.wscode.model.EmployeeCheckRequest.getDefaultInstance()) return this;
      if (other.getEmployeeId() != 0) {
        setEmployeeId(other.getEmployeeId());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.wscode.model.EmployeeCheckRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.wscode.model.EmployeeCheckRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int employeeId_ ;
    /**
     * <code>int32 employee_id = 1;</code>
     */
    public int getEmployeeId() {
      return employeeId_;
    }
    /**
     * <code>int32 employee_id = 1;</code>
     */
    public Builder setEmployeeId(int value) {
      
      employeeId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 employee_id = 1;</code>
     */
    public Builder clearEmployeeId() {
      
      employeeId_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:EmployeeCheckRequest)
  }

  // @@protoc_insertion_point(class_scope:EmployeeCheckRequest)
  private static final com.wscode.model.EmployeeCheckRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.wscode.model.EmployeeCheckRequest();
  }

  public static com.wscode.model.EmployeeCheckRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<EmployeeCheckRequest>
      PARSER = new com.google.protobuf.AbstractParser<EmployeeCheckRequest>() {
    @java.lang.Override
    public EmployeeCheckRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new EmployeeCheckRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<EmployeeCheckRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<EmployeeCheckRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.wscode.model.EmployeeCheckRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

