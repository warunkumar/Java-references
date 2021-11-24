package aggregator.service;

import aggregator.dto.RecommendedMovie;
import aggregator.dto.UserGenre;
import com.demo.proto.common.Genre;
import com.demo.proto.movie.MovieSearchRequest;
import com.demo.proto.movie.MovieSearchResponse;
import com.demo.proto.movie.MovieServiceGrpc;
import com.demo.proto.user.UserGenreUpdateRequest;
import com.demo.proto.user.UserResponse;
import com.demo.proto.user.UserSearchRequest;
import com.demo.proto.user.UserServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.List;
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
