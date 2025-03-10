package com.Springboot.BookReviewApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.Springboot.BookReviewApplication.entities")
public class BookReviewApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(BookReviewApplication.class, args);
	}

}
