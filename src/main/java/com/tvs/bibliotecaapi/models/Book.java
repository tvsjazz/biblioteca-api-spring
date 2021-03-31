package com.tvs.bibliotecaapi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private int paginas;

    @Column(nullable = false)
    private String descricao;

    @Column(name = "nome_reserva")
    private String nomeReserva;

    @Column(nullable = false)
    private boolean reservado;

    @Column(nullable = false)
    private boolean emprestado;

    public Book(Book book) {

    }
}
