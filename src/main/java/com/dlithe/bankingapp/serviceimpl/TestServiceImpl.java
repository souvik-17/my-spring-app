package com.dlithe.bankingapp.serviceimpl;

import com.dlithe.bankingapp.dto.FetchMovies;
import com.dlithe.bankingapp.dto.InstagramSignUp;
import com.dlithe.bankingapp.dto.MovieDetails;
import com.dlithe.bankingapp.dto.MovieReview;
import com.dlithe.bankingapp.entity.Movies;
import com.dlithe.bankingapp.repository.MoviesDAO;
import com.dlithe.bankingapp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private MoviesDAO moviesDAO;

    public String fetchProductDetails(String productName) {

        if (productName != null) {
            switch (productName) {
                case "A":
                    return "RayBan Sunglasses Starts from 1500 Rupees";
                case "B":
                    return "Apple Iphone is about to launch iphone 14";
                default:
                    return "No product Found";
            }
        } else
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
        MovieReview movieReview = new MovieReview();
        MovieReview movieReview1 = new MovieReview();
        List<MovieReview> movieReviewList = new ArrayList<>();

        MovieDetails movieDetails = new MovieDetails();
        movieDetails.setName(movie.getName());
        movieDetails.setDate(movie.getDate());


        movieReview.setName("Souvik");
        movieReview.setDescription("This is very interesting movie ");
        movieReview.setRating("4.7");
        movieReviewList.add(movieReview);

        movieReview1.setName("Rahul");
        movieReview1.setDescription("It was okay ");
        movieReview1.setRating("3.5");
        movieReviewList.add(movieReview1);

       movieDetails.setMovieReview(movieReviewList);

        return movieDetails;
    }

    @Override
    public MovieDetails fetchMovieDetailsByMovieName(int id,String movieName) {

        MovieDetails movieDetails = new MovieDetails();

        Movies movies = moviesDAO.findByMovieNameAndId(id,movieName);

        movieDetails.setId(movies.getId());
        movieDetails.setName(movies.getName());
        movieDetails.setDate(movies.getDate());

        return movieDetails;
    }


}

