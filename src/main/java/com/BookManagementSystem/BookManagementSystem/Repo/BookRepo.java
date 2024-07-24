package com.BookManagementSystem.BookManagementSystem.Repo;

import com.BookManagementSystem.BookManagementSystem.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository <Book,Long> {
}
