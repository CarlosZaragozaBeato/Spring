package com.example._restdatajpa.services;

import com.example._restdatajpa.model.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {
    @Test
    void calculatePrice() {
        BookPriceCalculator calculator = new BookPriceCalculator();
        double price = calculator.calculatePrice(new Book(null, "titulo","author",350,200, LocalDate.now(), false));
        System.out.println(price);
        assertTrue(price>0);
        assertEquals(207.99, price);
    }
}