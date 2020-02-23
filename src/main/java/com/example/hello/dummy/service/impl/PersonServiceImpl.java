package com.example.hello.dummy.service.impl;

import com.example.hello.dummy.entity.Person;
import com.example.hello.dummy.repository.PersonRepository;
import com.example.hello.dummy.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public List<Person> findByName(String name) {
        return personRepository.findByName(name);
    }

    @Override
    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public Person create(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deleteById(Long personId) {
        personRepository.deleteById(personId);
    }
}
