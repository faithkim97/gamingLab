package com.smith.gamingLab.repository;

import com.smith.gamingLab.table.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> {
//    @Query(value = "select * from game where title=?1 ", nativeQuery = true)
//    Game getGameByField(String title);


}
