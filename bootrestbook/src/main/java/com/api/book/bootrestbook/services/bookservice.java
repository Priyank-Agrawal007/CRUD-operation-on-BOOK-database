package com.api.book.bootrestbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class bookservice {


    @Autowired
    private BookRepository bookRepository;

/* 
    private static List<Book> list= new ArrayList<>();

    static{
        list.add(new Book(12, "Java Complete Reference", "XYZ"));
        list.add(new Book(36, "Two States", "Chetan Bhagat"));
        list.add(new Book(40, "Harry Potter", "JK Rowling"));
    }
 */
    public List<Book> getAllBooks(){
        List<Book> list= (List<Book>)this.bookRepository.findAll();
        return list;
    }

    public Book getBookById(int id){
        return this.bookRepository.findById(id);
    }

    public void addBook(Book b){
        this.bookRepository.save(b);
    }

    public void deleteBook(int id){
        bookRepository.deleteById(id);
    }

    public void updateBook(int id, Book book){
        book.setId(id);
        bookRepository.save(book);
    }
}
