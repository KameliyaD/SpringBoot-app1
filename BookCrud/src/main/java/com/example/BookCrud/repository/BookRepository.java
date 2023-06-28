package com.example.BookCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookCrud.domain.Book;

@Repository
public interface BookRepository  extends JpaRepository<Book, Long>{

}
