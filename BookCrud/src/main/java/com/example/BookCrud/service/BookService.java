package com.example.BookCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookCrud.domain.Book;
import com.example.BookCrud.repository.BookRepository;


@Service
public class BookService {
	
	
    @Autowired
    private BookRepository repo;
    
    public List<Book> listAll() {
        return repo.findAll();
    }
     
    public void save(Book b) {
        repo.save(b);
    }
     
    public Book get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
	
}
