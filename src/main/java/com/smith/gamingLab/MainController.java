package com.smith.gamingLab;

import com.smith.gamingLab.service.PersonService;
import com.smith.gamingLab.table.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    PersonService personService;

    @RequestMapping("/")
    private String getHello() { return "hello"; }

    @GetMapping("/persons")
    private List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/persons/{id}")
    private Person getPerson(@PathVariable("id") int id) {
        return personService.getPersonById(id);
    }

    @DeleteMapping("/persons/{id}")
    private void deletePerson(@PathVariable("id") int id) {
        personService.delete(id);
    }

    @GetMapping("/addPerson/{name}")
    private void addPerson(@PathVariable("name") String name) {
        Person p = new Person();
        p.setName(name);
        personService.saveOrUpdate(p);
    }

    @GetMapping("/getPerson/{name}")
    private Person getPersonByName(@PathVariable("name") String name) {
        return personService.getPersonByName(name);
    }


}
