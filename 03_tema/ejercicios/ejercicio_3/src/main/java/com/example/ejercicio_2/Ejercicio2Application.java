package com.example.ejercicio_2;

import com.example.ejercicio_2.example.Persona;
import com.example.ejercicio_2.example.PersonaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class Ejercicio2Application {

	public static void main(String[] args) {

		ApplicationContext context =  SpringApplication.run(Ejercicio2Application.class, args);

		PersonaRepository repository = (PersonaRepository) context.getBean("personaRepository");
		
		Persona prs = new Persona(null, "Carlos","Zaragoza", LocalDate.now());
		repository.save(prs);
		System.out.println(repository.count());
		System.out.println(repository.findAll());
	}

}
