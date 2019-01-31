package com.smith.gamingLab.repository;

import com.smith.gamingLab.table.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
