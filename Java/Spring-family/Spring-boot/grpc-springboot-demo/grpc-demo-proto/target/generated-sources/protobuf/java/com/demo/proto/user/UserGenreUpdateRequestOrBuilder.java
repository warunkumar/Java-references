// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: user-service.proto

package com.demo.proto.user;

public interface UserGenreUpdateRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:UserGenreUpdateRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string login_id = 1;</code>
   */
  java.lang.String getLoginId();
  /**
   * <code>string login_id = 1;</code>
   */
  com.google.protobuf.ByteString
      getLoginIdBytes();

  /**
   * <code>.common.Genre genre = 2;</code>
   */
  int getGenreValue();
  /**
   * <code>.common.Genre genre = 2;</code>
   */
  com.demo.proto.common.Genre getGenre();
}
