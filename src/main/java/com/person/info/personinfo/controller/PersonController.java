package com.person.info.personinfo.controller;

import com.person.info.personinfo.service.PersonService;

import java.util.List;

import com.person.info.personinfo.entity.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "persons")
    public List<Person> getAllPerson() {
        List<Person> personList = this.personService.getAllPerson();
        return personList;
    }

    @GetMapping("persons/{personId}")
    public Person getPerson(@PathVariable(name = "personId") Long personId) {
        return this.personService.getPerson(personId);
    }

    @PostMapping("persons")
    public void savePerson(@RequestBody Person person) {
        System.out.println(person.getFirstName() + person.getLastName());
        this.personService.savePerson(person);
    }

    @DeleteMapping("persons/{personId}")
    public void deletePerson(@PathVariable(name = "personId") Long personId) {
        personService.deletePerson(personId);
    }

    @PutMapping("persons/{personId}")
    public void updatePerson(@RequestBody Person person, @PathVariable(name = "personId") Long personId) {
        Person emp = personService.getPerson(personId);
        if (emp != null) {
            this.personService.updatePerson(person);
        }
    }
}