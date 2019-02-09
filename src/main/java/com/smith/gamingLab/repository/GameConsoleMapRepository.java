package com.smith.gamingLab.repository;

import com.smith.gamingLab.table.Console;
import com.smith.gamingLab.table.Game;
import com.smith.gamingLab.table.GameConsoleMap;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameConsoleMapRepository extends CrudRepository<GameConsoleMap, Integer> {

    @Query(value = "select console from game_console where game.id = ?1", nativeQuery = true)
    List<Console> getConsolesByGameId(int gameId);

    @Query(value = "select game from game_console where console.id = ?1", nativeQuery = true)
    List<Game> getGamesByConsoleId(int consoleId);
}
