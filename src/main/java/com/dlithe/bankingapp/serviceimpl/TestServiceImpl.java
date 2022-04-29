package com.dlithe.bankingapp.serviceimpl;

import com.dlithe.bankingapp.dto.InstagramSignUp;
import com.dlithe.bankingapp.dto.MovieDetails;
import com.dlithe.bankingapp.entity.Movies;
import com.dlithe.bankingapp.repository.MoviesDAO;
import com.dlithe.bankingapp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private MoviesDAO moviesDAO;

    public String fetchProductDetails(String productName) {

        if(productName != null) {
            switch (productName) {
                case "A":
                    return "RayBan Sunglasses Starts from 1500 Rupees";
                case "B":
                    return "Apple Iphone is about to launch iphone 14";
                default:
                    return "No product Found";
            }
        }
        else
            return "you have not specified any product";
    }

    @Override
    public String registerNewUser(InstagramSignUp instagramSignUp) {
        System.out.println(instagramSignUp);
        return null;
    }
    


    @Override
    public String addMovies(MovieDetails movieDetails) {

        Movies movies = new Movies();
        movies.setName(movieDetails.getName());
        movies.setDate(movieDetails.getDate());

        moviesDAO.save(movies);
        return "Movie saved succesfully";
    }

    @Override
    public MovieDetails getMovieDetails(int moviesId) {
        Optional<Movies> movies = moviesDAO.findById(moviesId);
        Movies movie = movies.get();
        MovieDetails movieDetails = new MovieDetails();
        movieDetails.setName(movies.get().getName());
        movieDetails.setDate(movies.get().getDate());
        return movieDetails;
    }

}

