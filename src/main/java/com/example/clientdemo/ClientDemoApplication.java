package com.example.clientdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientDemoApplication.class, args);

		String movie = Movie.builder()
				.imdb_id("121234")
				.belongs_to_collection(null)
				.original_title("harry potter")
				.original_language("en")
				.build()
				.toString();
	}



}
