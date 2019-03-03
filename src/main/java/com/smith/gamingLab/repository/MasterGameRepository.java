package com.smith.gamingLab.repository;

import com.smith.gamingLab.table.MasterGame;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MasterGameRepository extends CrudRepository<MasterGame, Integer> {

    String fullTable = "select * from master_game\n" +
            "left join game on game.id = game_id\n" +
            "left join game_console on game_console.game_id = master_game.game_id\n";

    String key = "(?1 is null or title like %?1% or description like %?1% or genres like %?1%)";

    @Query(value = fullTable + " where (?1 is null or title like %?1% or description like %?1% or genres like %?1%)" +
            " and (?2 is null or is_checked_out = ?2) and (?3 is null or is_digital = ?3)" +
            " and (?4 is null or console_id = ?4) and (?5 is null or modes like %?5%)"+
            " and (?6 is null or rating = ?6)", nativeQuery = true)
    List<MasterGame> getGamesByKeyword(String key, Boolean checkedOut, Boolean isDigital, Integer consoleId, String mode, Integer rating);

}
