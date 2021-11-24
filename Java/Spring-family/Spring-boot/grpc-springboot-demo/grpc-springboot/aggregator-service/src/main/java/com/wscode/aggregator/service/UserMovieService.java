package com.wscode.aggregator.service;

import com.wscode.aggregator.dto.RecommendedMovie;
import com.wscode.aggregator.dto.UserGenre;
import com.wscode.spbootgrpc.common.Genre;
import com.wscode.spbootgrpc.movie.MovieSearchRequest;
import com.wscode.spbootgrpc.movie.MovieSearchResponse;
import com.wscode.spbootgrpc.movie.MovieServiceGrpc;
import com.wscode.spbootgrpc.user.UserGenreUpdateRequest;
import com.wscode.spbootgrpc.user.UserResponse;
import com.wscode.spbootgrpc.user.UserSearchRequest;
import com.wscode.spbootgrpc.user.UserServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * @author Warun
 * @createdOn 12-10-2021
 **/

@Service
public class UserMovieService {

    @GrpcClient("user-service")
    private UserServiceGrpc.UserServiceBlockingStub userStub;

    @GrpcClient("movie-service")
    private MovieServiceGrpc.MovieServiceBlockingStub movieStub;

    public List<RecommendedMovie> getUserMovieSuggestions(String loginId){
        UserSearchRequest userSearchRequest=UserSearchRequest.newBuilder().setLoginId(loginId).build();
        UserResponse userResponse=this.userStub.getUserGenre(userSearchRequest);
        MovieSearchRequest movieSearchRequest=MovieSearchRequest.newBuilder().setGenre(userResponse.getGenre()).build();
        MovieSearchResponse movieSearchResponse=this.movieStub.getMovies(movieSearchRequest);
        return  movieSearchResponse.getMovieList()
                .stream()
                .map(movieDto -> new RecommendedMovie(movieDto.getTitle(),movieDto.getYear(),movieDto.getRating()))
                .collect(Collectors.toList());

    }

    public void setUserGenre(UserGenre userGenre){
        UserGenreUpdateRequest userGenreUpdateRequest=UserGenreUpdateRequest.newBuilder()
                .setLoginId(userGenre.getLoginId())
                .setGenre(Genre.valueOf(userGenre.getGenre().toUpperCase()))
                .build();
        UserResponse userResponse=this.userStub.updateUserGenre(userGenreUpdateRequest);
    }
}
