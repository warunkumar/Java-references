package com.wscode.movie.service;

import com.wscode.movie.repository.MovieRepository;
import com.wscode.spbootgrpc.movie.MovieDto;
import com.wscode.spbootgrpc.movie.MovieSearchRequest;
import com.wscode.spbootgrpc.movie.MovieSearchResponse;
import com.wscode.spbootgrpc.movie.MovieServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Warun
 * @createdOn 11-10-2021
 **/
@GrpcService
public class MovieService extends MovieServiceGrpc.MovieServiceImplBase {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void getMovies(MovieSearchRequest request, StreamObserver<MovieSearchResponse> responseObserver) {
        List<MovieDto> movieDtoList=this.movieRepository.getMovieByGenreOrderByYearDesc(request.getGenre().toString())
                .stream()
                .map(movie -> MovieDto.newBuilder()
                        .setTitle(movie.getTitle())
                        .setYear(movie.getYear())
                        .setRating(movie.getRating())
                        .build()).collect(Collectors.toList());

        responseObserver.onNext(MovieSearchResponse.newBuilder().addAllMovie(movieDtoList).build());
        responseObserver.onCompleted();
    }

}
