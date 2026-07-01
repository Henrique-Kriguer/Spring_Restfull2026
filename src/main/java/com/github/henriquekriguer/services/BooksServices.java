package com.github.henriquekriguer.services;

import com.github.henriquekriguer.data.dto.v1.BooksDTO;
import com.github.henriquekriguer.exception.ResourceNotFoundException;
import com.github.henriquekriguer.mapper.custom.BooksMapper;
import com.github.henriquekriguer.repository.BooksRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.github.henriquekriguer.mapper.ObjectMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.util.List;

import static com.github.henriquekriguer.mapper.ObjectMapper.parseListObjects;

@Service
public class BooksServices {

    private Logger logger = LoggerFactory.getLogger(BooksServices.class.getName());

    @Autowired
    BooksRepository booksRepository;

    @Autowired
    BooksMapper booksConverter;

    public List<BooksDTO> findAll(){
        logger.info("findind all books!");
        var books = parseListObjects(booksRepository.findAll(), BooksDTO.class);
        //books.forEach( this::addHateoasLinks);
        return books;
    }
    
    public BooksDTO findById(Long id){
        logger.info("find books by id!");
        var books = booksRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
        var dto = parseObject(books, BooksDTO.class);
        //addHateoasLinks(dto);
        return dto;
    }
}
