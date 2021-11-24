package com.wscode.movie.repository;

import com.wscode.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Warun
 * @createdOn 11-10-2021
 **/
@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    List<Movie> getMovieByGenreOrderByYearDesc(String genre);

}
