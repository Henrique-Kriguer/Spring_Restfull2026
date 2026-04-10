package com.github.henriquekriguer;

import com.github.henriquekriguer.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){
        logger.info("Finding all people!");
        List<Person> persons = new ArrayList<Person>();
            for (int i = 0; i < 8; i++) {
                Person person = mockPerson(i);
                persons.add(person);
            }
        return persons;
    }

    private Person mockPerson(int i) {

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("First name " + i);
        person.setLastName("Last Name " + i);
        person.setAddress("Some Address in Brazil " + i);
        person.setGender("Male");
        return person;
    }

    public Person findById(String id){
        logger.info("Finding one Person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Henrique");
        person.setLastName("Kriguer");
        person.setAddress("Guaratinguetá - SP - Brasil");
        person.setGender("Male");
        return person;
    }

    public Person create(Person person){
        logger.info("Creating a new Person!");
        return person;

    }public Person update(Person person){
        logger.info("Updating a Person!");
        return person;
    }

    public void delete(String id){
        logger.info("Deleting a Person!");
    }
}
