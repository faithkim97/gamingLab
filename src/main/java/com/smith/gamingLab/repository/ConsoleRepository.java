package com.smith.gamingLab.repository;

import com.smith.gamingLab.table.Console;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ConsoleRepository extends CrudRepository<Console, Integer> {

    @Query(value = "select * from console where console = ?1", nativeQuery = true)
    Console getConsoleByType(String consoleTyoe);
}
