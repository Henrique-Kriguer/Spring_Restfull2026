package com.github.henriquekriguer.mapper.custom;

import com.github.henriquekriguer.data.dto.v1.PersonDTO;
import com.github.henriquekriguer.data.dto.v2.PersonDTOV2;
import com.github.henriquekriguer.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonDTO convertEntityToDTO(Person person) {
        PersonDTO dto = new PersonDTO();
        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        //dto.setDateOfBirth(new Date());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());
        return dto;
    }

    public Person convertDTOToEntity(PersonDTO person) {
        Person entity  = new Person();
        entity.setId(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        //entity.setDateOfBirth(new Date());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return entity;
    }
}
