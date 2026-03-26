package com.github.henriquekriguer.controllers;

import com.github.henriquekriguer.PersonServices;
import com.github.henriquekriguer.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//http://localhost:9090/person/1
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;

    @RequestMapping(value = "/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person findById(@PathVariable("id") String id) {

        return service.findById(id);
    }
    //http://localhost:9090/person/1

    @RequestMapping(value = "")
        public List<Person> findAll() {
            return service.findAll();
    }
}
