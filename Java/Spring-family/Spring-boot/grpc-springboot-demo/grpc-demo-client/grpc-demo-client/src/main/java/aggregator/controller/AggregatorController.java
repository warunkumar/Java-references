package aggregator.controller;

import aggregator.dto.RecommendedMovie;
import aggregator.service.UserMovieService;
import aggregator.dto.RecommendedMovie;
import aggregator.dto.UserGenre;
import aggregator.service.UserMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Warun
 * @createdOn 12-10-2021
 **/
@RestController
public class AggregatorController {

    @Autowired
    UserMovieService userMovieService;

    @GetMapping("/user/{loginId}")
    public List<RecommendedMovie> getMovie(@PathVariable String loginId){
        return this.userMovieService.getUserMovieSuggestions(loginId);
    }

    @PutMapping("/user/")
    public void setUserGenre(@RequestBody UserGenre userGenre){
        this.userMovieService.setUserGenre(userGenre);
    }
}
