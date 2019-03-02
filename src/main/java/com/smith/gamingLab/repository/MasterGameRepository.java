package com.smith.gamingLab.repository;

import com.smith.gamingLab.table.MasterGame;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MasterGameRepository extends CrudRepository<MasterGame, Integer> {

    @Query(value = "select * from master_game where (?1 is null or title like %?1% or description like %?1% or genre like %?1%)" +
            " and (?2 is null or is_checked_out = ?2) and (?3 is null or is_digital = ?3)" +
            " and (?4 is null or console = ?4) and (?5 is null or mode like %?5%)"+
            " and (?6 is null or rating = ?6)", nativeQuery = true)
    List<MasterGame> getGamesByKeyword(String key, Boolean checkedOut, Boolean isDigital, String console, String mode, Integer rating);
}
