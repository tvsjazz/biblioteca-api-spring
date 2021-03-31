package com.tvs.bibliotecaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String titulo;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String autor;

    @NotEmpty
    private int paginas;

    @NotEmpty
    @Size(min = 2, max = 500)
    private String descricao;

    @Size(min = 2, max = 100)
    private String nomeReserva;

    private boolean reservado;

    private boolean emprestado;

}
