package com.example.hello.dummy.service;

import com.example.hello.dummy.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    List<Person> findAll();

    List<Person> findByName(String name);

    Optional<Person> findById(Long personId);

    Person create(Person person);

    void deleteById(Long personId);
}
