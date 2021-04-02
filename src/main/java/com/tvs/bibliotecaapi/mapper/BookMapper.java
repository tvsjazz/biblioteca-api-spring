package com.tvs.bibliotecaapi.mapper;

import com.tvs.bibliotecaapi.dto.BookDTO;
import com.tvs.bibliotecaapi.models.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book toModel(BookDTO bookDTO);

    BookDTO toDTO(Book book);

}
