package com.example.clientdemo;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
    private String imdb_id;
    private String original_language;
    private String original_title;
    private MovieCollection belongs_to_collection;
}
