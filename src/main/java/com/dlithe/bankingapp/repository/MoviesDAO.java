package com.dlithe.bankingapp.repository;


import com.dlithe.bankingapp.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesDAO extends JpaRepository<Movies,Integer> {
}
