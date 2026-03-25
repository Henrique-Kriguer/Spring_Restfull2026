package com.github.henriquekriguer;

import com.github.henriquekriguer.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id){
        logger.info("Finding one Peerson!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Henrique");
        person.setLastName("Kriguer");
        person.setAddress("Guaratinguetá - SP - Brasil");
        person.setGender("Male");
        return person;
    }
}
