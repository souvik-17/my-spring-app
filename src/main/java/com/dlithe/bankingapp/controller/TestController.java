package com.dlithe.bankingapp.controller;


import com.dlithe.bankingapp.dto.BaseResponse;
import com.dlithe.bankingapp.dto.InstagramSignUp;
import com.dlithe.bankingapp.dto.MovieDetails;
import com.dlithe.bankingapp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//
//    @GetMapping("fetch-movie-details/{movieId}")
//        public ResponseEntity<BaseResponse> fetchMovieDetailsByMovieId (@PathVariable int movieId){
//        if(movieId==0 || String.valueOf(movieId)==null){
//            return new ResponseEntity<BaseResponse>(new BaseResponse("Movie ID can not be zero or Null",HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value(),null));
//        }
//
//        return testService.fetchMovieDetailsByMovieName(movieId);
//    }

}

