package com.smith.gamingLab.repository;

import com.smith.gamingLab.table.Game;
import com.smith.gamingLab.table.GamePlayableModeMap;
import com.smith.gamingLab.table.PlayableMode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GamePlayableModeMapRepository extends CrudRepository<GamePlayableModeMap, Integer> {

    @Query(value = "select * from game_mode where mode_id = ?1", nativeQuery = true)
    List<GamePlayableModeMap> getMappingByPlayableId(int playableId);

    @Query(value = "select * from game_mode where game_id = ?1", nativeQuery = true)
    List<GamePlayableModeMap> getMappingByGameId(int id);

    @Query(value = "select * from game_mode where game_id = ?1 and mode_id = ?2", nativeQuery = true)
    List<GamePlayableModeMap> getMappingByGameAndModeIds (int gameId, int modeId);





}
