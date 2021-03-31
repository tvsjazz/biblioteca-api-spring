package com.tvs.bibliotecaapi.service;

import com.tvs.bibliotecaapi.dto.BookDTO;
import com.tvs.bibliotecaapi.dto.MessageResponseDTO;
import com.tvs.bibliotecaapi.exception.BookNotFoundException;
import com.tvs.bibliotecaapi.models.Book;
import com.tvs.bibliotecaapi.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookService {

    private BookRepository bookRepository;

    private Book verifyIfExists(Long id) throws BookNotFoundException {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

    public List<Book> listAll(int pagina, int qtd) {
        Pageable paginacao = PageRequest.of(pagina, qtd);
        Page<Book> allBooks = bookRepository.findAll(paginacao);
        return allBooks.toList();
    }

    public Book findById(Long id) throws BookNotFoundException {
        Book book = verifyIfExists(id);
        return book;
    }

    public MessageResponseDTO createPerson(Book book) {
        Book bookSaved = bookRepository.save(book);
        return createMessageResponse(bookSaved.getId(), "Created book with ID ");
    }



}
