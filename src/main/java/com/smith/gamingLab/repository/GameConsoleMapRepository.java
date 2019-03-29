package com.smith.gamingLab.repository;

import com.smith.gamingLab.table.Console;
import com.smith.gamingLab.table.Game;
import com.smith.gamingLab.table.GameConsoleMap;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameConsoleMapRepository extends CrudRepository<GameConsoleMap, Integer> {

    @Query(value = "select * from game_console where game_id = ?1", nativeQuery = true)
    List<GameConsoleMap> getMappingByGameId(int gameId);

    @Query(value = "select * from game_console where console_id = ?1", nativeQuery = true)
    List<GameConsoleMap> getMappingByConsoleId(int consoleId);

}
