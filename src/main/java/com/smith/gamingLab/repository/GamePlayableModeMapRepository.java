package com.smith.gamingLab.repository;

import com.smith.gamingLab.table.Game;
import com.smith.gamingLab.table.GamePlayableModeMap;
import com.smith.gamingLab.table.PlayableMode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GamePlayableModeMapRepository extends CrudRepository<GamePlayableModeMap, Integer> {

    @Query(value = "select * from game_mode where playable_mode.id = ?1", nativeQuery = true)
    List<Game> getGamesByMode(int id);

    @Query(value = "select * from game_mode where game.id = ?1", nativeQuery = true)
    List<PlayableMode> getModesByGameId(int id);



}
