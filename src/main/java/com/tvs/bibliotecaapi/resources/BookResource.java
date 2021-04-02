package com.tvs.bibliotecaapi.resources;

import com.tvs.bibliotecaapi.dto.BookDTO;
import com.tvs.bibliotecaapi.dto.MessageResponseDTO;
import com.tvs.bibliotecaapi.exception.BookNotFoundException;
import com.tvs.bibliotecaapi.models.Book;
import com.tvs.bibliotecaapi.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createBook(@RequestBody Book book) {
        return bookService.createPerson(book);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody BookDTO bookDTO) throws BookNotFoundException {
        return bookService.updateById(id, bookDTO);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws BookNotFoundException {
        bookService.delete(id);
    }

}
