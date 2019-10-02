package com.person.info.personinfo.service;

import com.person.info.personinfo.entity.Person;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {

    public List<Person> getAllPerson();

    public Person getPerson(Long personId);

    public void savePerson(Person person);

    public void deletePerson(Long personId);

    public void updatePerson(Person person);

}