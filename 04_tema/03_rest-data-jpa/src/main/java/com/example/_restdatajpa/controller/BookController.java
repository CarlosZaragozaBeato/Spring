package com.example._restdatajpa.controller;

import com.example._restdatajpa.model.Book;
import com.example._restdatajpa.repository.BookRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {


    private final Logger log = LoggerFactory.getLogger(BookController.class);

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    //Crud sobre la entidad BOOK
    //Buscar todos los libros
    @GetMapping("/api/books")
    public List<Book> findAll(){
    //Recuperar y devolver los libros de la base de datos
        return bookRepository.findAll();
    }
    //Buscar un libro segun su id
    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        //return bookOpt.orElse(null);
        if (bookOpt.isPresent()){
            return ResponseEntity.ok(bookOpt.get());
        }else{
            return ResponseEntity.notFound().build();
        }

       // return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Guardar un nuevo libro

    @PostMapping("/api/books")
    public ResponseEntity<Book> create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        if (book.getId() != null) {// Existe el id
            log.warn("trying to create a book with a existing id");
            System.out.println("trying to create a book with a existing id");
            return ResponseEntity.badRequest().build();
        }
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);

    }
    //Actualizar los libros existentes
    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book book){
     /*   Optional<Book> bookOpt = bookRepository.findById(book.getId());

        if(bookOpt.isPresent())
            return ResponseEntity.ok(bookOpt.get());
        else
            return ResponseEntity.notFound().build();
       return bookRepository.save(book);*/

        if (!bookRepository.existsById(book.getId())) {
            log.warn("trying to create a book with a null id");
            System.out.println("trying to create a book with a null id");
            return ResponseEntity.badRequest().build();
        }
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }

    //borrar un libro de la base de datos
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id){
        try{
            bookRepository.deleteById(id);
        }catch (Exception ex){log.error(ex.getMessage());}
        return ResponseEntity.noContent().build();
    }
    //borrar todos los libros
    @DeleteMapping("/api/books/deleteAll")
    public ResponseEntity<Book> deleteAll(){
       if (bookRepository.count() == 0){
           return ResponseEntity.badRequest().build();
       }
       log.info("Deleting all books");
       bookRepository.deleteAll();
       return ResponseEntity.noContent().build();
    }
}
