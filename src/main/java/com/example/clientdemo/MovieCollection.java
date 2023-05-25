package com.example.clientdemo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieCollection {
    private int id;
    private String name;
    private String poster_path;
    private String backdrop_path;
}
