package com.smith.gamingLab.repository;

import com.smith.gamingLab.table.Console;
import com.smith.gamingLab.table.GameConsoleMap;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface GameConsoleMapRepository extends CrudRepository<GameConsoleMap, Integer> {

    @Query(value = "select console from game_console where game.id = ?1", nativeQuery = true)
    Console getConsoleByGameId(int gameId);
}
