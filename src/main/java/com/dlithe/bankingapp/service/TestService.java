package com.dlithe.bankingapp.service;


import com.dlithe.bankingapp.dto.InstagramSignUp;
import com.dlithe.bankingapp.dto.MovieDetails;
import org.springframework.stereotype.Component;

@Component
public interface TestService {
    String fetchProductDetails(String productName);

    String registerNewUser(InstagramSignUp instagramSignUp);

    String addMovies(MovieDetails movieDetails);

    MovieDetails getMovieDetails(int moviesId);

    MovieDetails fetchMovieDetailsByMovieName(int movieId,String movieName);
}
