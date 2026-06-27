package com.github.henriquekriguer.repository;

import com.github.henriquekriguer.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
   //Object create();
}
