package com.smith.gamingLab.repository;

import com.smith.gamingLab.table.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Query(value = "select * from person where name=?1", nativeQuery = true)
    Person getPersonByName(String n);

}
