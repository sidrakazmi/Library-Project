package com.lexicon.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Sidra Kazmi on 08/06/18.
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.lexicon"})
@EntityScan(basePackages = {"com.lexicon.models"})
@EnableJpaRepositories(basePackages={"com.lexicon.repositories"})

public class LibraryProjektApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(LibraryProjektApplication.class, args);
	}
}
