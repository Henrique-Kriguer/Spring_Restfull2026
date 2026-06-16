package com.github.henriquekriguer.services;

import com.github.henriquekriguer.controllers.PersonController;
import com.github.henriquekriguer.data.dto.v1.PersonDTO;
import com.github.henriquekriguer.data.dto.v2.PersonDTOV2;
import com.github.henriquekriguer.exception.RequiredObjectIsNullException;
import com.github.henriquekriguer.exception.ResourceNotFoundException;
import static com.github.henriquekriguer.mapper.ObjectMapper.parseListObjects;
import static com.github.henriquekriguer.mapper.ObjectMapper.parseObject;

import com.github.henriquekriguer.mapper.custom.PersonMapper;
import com.github.henriquekriguer.model.Person;
import com.github.henriquekriguer.repository.PersonRepository;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class PersonServices {


    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper converter;

    public List<PersonDTO> findAll(){
        logger.info("Finding all people!");
        var persons =  parseListObjects(repository.findAll(), PersonDTO.class);
        persons.forEach( this::addHateoasLinks);
        return persons;
    }

    public PersonDTO findById(Long id){
        logger.info("Finding one Person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
        var dto = parseObject(entity, PersonDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    private void addHateoasLinks( PersonDTO dto) {
        dto.add(linkTo(methodOn(PersonController.class).findById(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(PersonController.class).findAll()).withRel("findAll").withType("GET"));
        dto.add(linkTo(methodOn(PersonController.class).create(dto)).withRel("create").withType("POST"));
        dto.add(linkTo(methodOn(PersonController.class).update(dto)).withRel("update").withType("PUT"));
        dto.add(linkTo(methodOn(PersonController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));
    }

    public PersonDTO create(PersonDTO person){
        if(person==null) throw new RequiredObjectIsNullException();
        logger.info("Creating a new Person!");
        var entity =  parseObject(person, Person.class);
        var dto = parseObject(repository.save(entity), PersonDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public PersonDTOV2 createV2(PersonDTOV2 person){
        logger.info("Creating a new Person V2!");
        var entity =  converter.convertDTOToEntity(person);
        return converter.convertEntityToDTO(repository.save(entity));
    }

    public PersonDTO update(PersonDTO person){
        if(person==null) throw new RequiredObjectIsNullException();
        logger.info("Updating a Person!");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        var dto =  parseObject(repository.save(entity), PersonDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public void delete(Long id){
        logger.info("Deleting a Person!");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
        repository.delete(entity);
    }
}
