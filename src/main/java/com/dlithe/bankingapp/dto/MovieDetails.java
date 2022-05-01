package com.dlithe.bankingapp.dto;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MovieDetails {
    private int id;
    private String name;
    private String date;
    private List<MovieReview> movieReview;

}
