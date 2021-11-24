package com.wscode.user.service;

import com.wscode.spbootgrpc.common.Genre;
import com.wscode.spbootgrpc.user.UserGenreUpdateRequest;
import com.wscode.spbootgrpc.user.UserResponse;
import com.wscode.spbootgrpc.user.UserSearchRequest;
import com.wscode.spbootgrpc.user.UserServiceGrpc;
import com.wscode.user.repository.UserRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Warun
 * @createdOn 11-10-2021
 **/
@GrpcService
public class UserService extends UserServiceGrpc.UserServiceImplBase {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void getUserGenre(UserSearchRequest request, StreamObserver<UserResponse> responseObserver) {
        UserResponse.Builder builder=UserResponse.newBuilder();
        this.userRepository.findById(request.getLoginId())
                .ifPresent(user->{
                    builder.setName(user.getName())
                            .setLoginId(user.getLogin())
                            .setGenre(Genre.valueOf(user.getGenre()));
                });
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void updateUserGenre(UserGenreUpdateRequest request, StreamObserver<UserResponse> responseObserver) {
        UserResponse.Builder builder=UserResponse.newBuilder();
        this.userRepository.findById(request.getLoginId())
                .ifPresent(user->{
                    user.setGenre(request.getGenre().toString());
                    builder.setName(user.getName())
                            .setLoginId(user.getLogin())
                            .setGenre(Genre.valueOf(user.getGenre()));
                });
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
}
