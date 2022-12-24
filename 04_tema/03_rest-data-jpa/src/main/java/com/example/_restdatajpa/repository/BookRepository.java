package com.example._restdatajpa.repository;

import com.example._restdatajpa.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository  extends JpaRepository <Book,Long>{ }
