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
        person.setFirstName("Person Name " + i);
        person.setLastName("Person Last Name " + i);
        person.setAddress("Some Address in Brazil " + i);
        person.setGender("Male");
        return person;
    }

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
