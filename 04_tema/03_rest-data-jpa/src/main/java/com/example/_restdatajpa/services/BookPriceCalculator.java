package com.example._restdatajpa.services;

import com.example._restdatajpa.model.Book;

public class BookPriceCalculator {

    public double calculatePrice(Book book) {
        double price = book.getPrice();
        price += book.getPages()>300? 5:0;
        price += 2.99;
        return price;
    }

}
