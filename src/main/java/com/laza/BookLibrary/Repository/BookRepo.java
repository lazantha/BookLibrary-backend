package com.laza.BookLibrary.Repository;

import com.laza.BookLibrary.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository <Book,Integer>{
}
