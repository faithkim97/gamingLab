package com.smith.gamingLab.repository;

import com.smith.gamingLab.table.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Long> {
    @Query(value = "select * from game where genres like %?1% ", nativeQuery = true)
    List<Game> getGameByGenre(String genre);

//    @Query(value = "select title, console_type, rating, modes, description where title like %?1% or" +
//            "description like %?2%", nativeQuery = true)
//    @Query(value = "select title from game where title like %?1% or " +
//            "description like %?2%", nativeQuery = true)
    //TODO when doing description like Survive--not case sensitive in url but it is in query
    //so it doesn't query for tomb raider as well
    @Query(value = "select * from game where title like %?1% or description like %?2%", nativeQuery = true)
    List<Game> getGames(String title, String description);

}
