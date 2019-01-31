package com.smith.gamingLab.service;

import com.smith.gamingLab.repository.PersonRepository;
import com.smith.gamingLab.table.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<Person>();
        personRepository.findAll().forEach(person -> persons.add(person));
        return persons;
    }

    public Person getPersonById(int id) {
        return personRepository.findById(id).get();
    }

    public void saveOrUpdate(Person person) {
        personRepository.save(person);
    }

    public void delete(int id) {
        personRepository.deleteById(id);
    }

    public Person getPersonByName(String name) {
        return personRepository.getPersonByName(name);
    }

}
