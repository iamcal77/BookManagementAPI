package com.BookManagementSystem.BookManagementSystem.Controller;

import com.BookManagementSystem.BookManagementSystem.Models.Book;
import com.BookManagementSystem.BookManagementSystem.Repo.BookRepo;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepo bookRepo;

    @GetMapping("/")
    public  String getPage(){
        return "Hello World";
    }

    @GetMapping (value ="/books")
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }
    @PostMapping (value ="/save")
    public String saveBook(@RequestBody Book book){
        bookRepo.save(book);
        return "book saved";
    }

    @PutMapping (value= "update/{id}")
    public String updatedBook(@PathVariable long id , @RequestBody Book book){
        Book updatedBook = bookRepo.findById(id).get();
        updatedBook.setTitle(book.getTitle());
        updatedBook.setAuthor(book.getAuthor());
        updatedBook.setGenre(book.getGenre());
        updatedBook.setYear(book.getYear());
        bookRepo.save(updatedBook);
        return "Book Updated";
    }
    @DeleteMapping (value ="delete/{id}")
    public  String deleteBook(@PathVariable long id){
        Book deleteBook = bookRepo.findById(id).get();
        bookRepo.delete(deleteBook);
        return "book deleted";


    }

}
