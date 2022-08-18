package com.api.book.bootrestbook.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.bookservice;

@RestController
public class BookController {
    
    @Autowired
    private bookservice bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){

        List<Book> list= this.bookService.getAllBooks();
        if(list.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id){

        Book book= bookService.getBookById(id);
        if(book==null)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.of(Optional.of(book));
    }

    @PostMapping("/books")
    public void addBook(@RequestBody Book book){
        this.bookService.addBook(book);
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int id){
        this.bookService.deleteBook(id);
    }

    @PutMapping("/books/{bookId}")
    public void updateBook(@RequestBody Book book,@PathVariable("bookId") int id){
        this.bookService.updateBook(id, book);
    }
}
