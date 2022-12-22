package com.example._restdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);

		//Operacions CRUD con libros ->
		BookRepository bookRepo= (BookRepository) context.getBean(BookRepository.class);

		//Crear Libro ->
		Book libro1 = new Book(null, "titulo1", "author1",351, 12.51, LocalDate.of(1951,10,20), false);
		Book libro2 = new Book(null, "titulo2", "author2",352, 12.52, LocalDate.of(1952,10,20), true);
		Book libro3 = new Book(null, "titulo3", "author3",353, 12.53, LocalDate.of(1953,10,20), false);

		//Guardar Libros ->
		bookRepo.save(libro1);
		bookRepo.save(libro2);
		bookRepo.save(libro3);



		//recuperar todos los libros ->
		for (Book lbr: bookRepo.findAll()){
			System.out.println(lbr);
		}

		//Eliminar Por Id ->
		bookRepo.deleteById(1L);
		//Contar Todos Los Libros ->
		System.out.println(bookRepo.count());
	}
}
