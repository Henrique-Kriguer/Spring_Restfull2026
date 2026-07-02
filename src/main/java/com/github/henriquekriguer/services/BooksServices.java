package com.github.henriquekriguer.services;

import com.github.henriquekriguer.controllers.BooksController;
import com.github.henriquekriguer.data.dto.v1.BooksDTO;
import com.github.henriquekriguer.exception.RequiredObjectIsNullException;
import com.github.henriquekriguer.exception.ResourceNotFoundException;
import com.github.henriquekriguer.model.Books;
import com.github.henriquekriguer.repository.BooksRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.github.henriquekriguer.mapper.ObjectMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

import static com.github.henriquekriguer.mapper.ObjectMapper.parseListObjects;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BooksServices {

    private Logger logger = LoggerFactory.getLogger(BooksServices.class.getName());

    @Autowired
    BooksRepository booksRepository;

    public List<BooksDTO> findAll(){
        logger.info("findind all books!");
        var books = parseListObjects(booksRepository.findAll(), BooksDTO.class);
        books.forEach( this::addHateoasLinks);
        return books;
    }
    
    public BooksDTO findById(Long id){
        logger.info("find books by id!");
        var books = booksRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
        var dto = parseObject(books, BooksDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public BooksDTO create(BooksDTO books){
        if(books == null) throw new RequiredObjectIsNullException("BooksDTO object is null");
        logger.info("creating books!");
        var entity = parseObject(books, Books.class);
        var dto = parseObject(booksRepository.save(entity), BooksDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public BooksDTO update(BooksDTO books){
        if(books == null) throw new RequiredObjectIsNullException("BooksDTO object is null");
        logger.info("updating books!");
        Books entity = booksRepository.findById(books.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
        entity.setAuthor(books.getAuthor());
        entity.setLaunchDate(books.getLaunchDate());
        entity.setPrice(books.getPrice());
        entity.setTitle(books.getTitle());
        var dto = parseObject(booksRepository.save(entity), BooksDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public void  delete(Long id){
        logger.info("deleting books!");
        Books entity = booksRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
        booksRepository.delete(entity);
    }

    private Date convertStringToDate(String dateString) {
        if (dateString == null || dateString.trim().isEmpty()) {
            return null;
        }
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            return formatter.parse(dateString);
        } catch (ParseException e) {
            logger.error("Error parsing date: " + dateString, e);
            throw new RuntimeException("Invalid date format. Expected: yyyy-MM-dd'T'HH:mm:ss.SSS");
        }
    }
    private void addHateoasLinks( BooksDTO dto) {
        dto.add(linkTo(methodOn(BooksController.class).findById(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(BooksController.class).findAll()).withRel("findAll").withType("GET"));
        dto.add(linkTo(methodOn(BooksController.class).create(dto)).withRel("create").withType("POST"));
        dto.add(linkTo(methodOn(BooksController.class).update(dto)).withRel("update").withType("PUT"));
        dto.add(linkTo(methodOn(BooksController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));

    }
    }
