package com.dlithe.bankingapp.controller;


import com.dlithe.bankingapp.dto.InstagramSignUp;
import com.dlithe.bankingapp.dto.MovieDetails;
import com.dlithe.bankingapp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("fetchProductDetails/{productName}")
    public String myFirstMethod(@PathVariable String productName) {
        return testService.fetchProductDetails(productName);
    }

    @PostMapping("register-instagram")
    public String registerNewUser(@RequestBody InstagramSignUp instagramSignUp) {
        return testService.registerNewUser(instagramSignUp);
    }

    @PostMapping("add-movies")
    public String addMovies(@RequestBody MovieDetails movieDetails){
        return testService.addMovies(movieDetails);
    }

    @GetMapping("get-movie-details/{moviesId}")
    public MovieDetails fetchMovieDetails(@PathVariable int moviesId){

        return testService.getMovieDetails(moviesId);
    }

    @GetMapping("fetch-movie-details/{movieId}/{movieName}")
        public MovieDetails fetchMovieDetailsByMovieName(@PathVariable int movieId, @PathVariable String movieName){
        return testService.fetchMovieDetailsByMovieName(movieId,movieName);
    }

}

