// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: employee-service.proto

package com.wscode.model;

public final class EmployeeServiceOuterClass {
  private EmployeeServiceOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_EmployeeCheckRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_EmployeeCheckRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Employee_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Employee_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026employee-service.proto\"+\n\024EmployeeChec" +
      "kRequest\022\023\n\013employee_id\030\001 \001(\005\"\037\n\010Employe" +
      "e\022\023\n\013employee_ph\030\001 \001(\0052B\n\017EmployeeServic" +
      "e\022/\n\013getEmployee\022\025.EmployeeCheckRequest\032" +
      "\t.EmployeeB\024\n\020com.wscode.modelP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_EmployeeCheckRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_EmployeeCheckRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_EmployeeCheckRequest_descriptor,
        new java.lang.String[] { "EmployeeId", });
    internal_static_Employee_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Employee_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Employee_descriptor,
        new java.lang.String[] { "EmployeePh", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}