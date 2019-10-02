package com.person.info.personinfo.service;

import java.util.List;
import java.util.Optional;

import com.person.info.personinfo.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.info.personinfo.entity.Person;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getAllPerson() {
        List<Person> personList = this.personRepository.findAll();
        return personList;
    }

    public Person getPerson(Long personId) {
        Optional<Person> optEmp = personRepository.findById(personId);
        return optEmp.get();
    }

    public void savePerson(Person person) {
        personRepository.save(person);
    }

    public void deletePerson(Long personId) {
        personRepository.deleteById(personId);
    }

    public void updatePerson(Person person) {
        personRepository.save(person);
    }
}