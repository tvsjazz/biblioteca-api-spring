package com.tvs.bibliotecaapi.resources;

import com.tvs.bibliotecaapi.exception.BookNotFoundException;
import com.tvs.bibliotecaapi.models.Book;
import com.tvs.bibliotecaapi.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookResource {

    private BookService bookService;

    @GetMapping
    public List<Book> listAll(@RequestParam int pagina, @RequestParam int qtd) {
        return bookService.listAll(pagina, qtd);
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) throws BookNotFoundException {
        return bookService.findById(id);
    }

    

}
