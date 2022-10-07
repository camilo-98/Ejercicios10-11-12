package com.example.Ejercicios456;

import com.example.Ejercicios456.Entities.Laptop;
import com.example.Ejercicios456.Repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicios101112Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Ejercicios101112Application.class, args);
		LaptopRepository repo = context.getBean(LaptopRepository.class);

		Laptop laptop1 = new Laptop(null, "Apple", 1998);
		Laptop laptop2 = new Laptop(null, "Asus", 2018);

		repo.save(laptop1);
		repo.save(laptop2);



	}

}
