package com.dlithe.bankingapp.repository;


import com.dlithe.bankingapp.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesDAO extends JpaRepository<Movies,Integer> {

    @Query(value = " select * from movies where id = ?1 and name = ?2", nativeQuery = true)
    Movies findByMovieNameAndId(int id,String movieName);
}
