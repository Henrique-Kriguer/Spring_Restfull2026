package com.github.henriquekriguer.mapper.custom;

import com.github.henriquekriguer.data.dto.v1.BooksDTO;
import com.github.henriquekriguer.model.Books;

public class BooksMapper {

    public BooksDTO convertEntityToDTO(Books books){
        BooksDTO bdto = new BooksDTO();
        bdto.setId(books.getId());
        bdto.setAuthor(books.getAuthor());
        bdto.setLaunch_date(books.getLaunch_date().toString());
        bdto.setTitle(books.getTitle());
        bdto.setPrice(books.getPrice());
        return bdto;
    }

    public Books convertDTOToEntity(BooksDTO books){
        Books entity = new Books();
        entity.setId(books.getId());
        entity.setAuthor(books.getAuthor());
        entity.setLaunch_date(java.sql.Date.valueOf(books.getLaunch_date()));
        entity.setTitle(books.getTitle());
        entity.setPrice(books.getPrice());
        return entity;

    }

}
