package com.tvs.bibliotecaapi.repository;

import com.tvs.bibliotecaapi.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
