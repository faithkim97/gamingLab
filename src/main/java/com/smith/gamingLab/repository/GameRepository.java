package com.smith.gamingLab.repository;

import com.smith.gamingLab.table.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Integer> {

    String full_table = "select * from game \n" +
            "left join game_genre_map on game.id = game_genre_map.game_id\n" +
            "left join genre on game_genre_map.genre_id = genre.id \n" +
            "left join game_console on game.id = game_console.game_id\n" +
            "left join console on game_console.console_id = console.id\n" +
            "left join game_mode on game.id = game_mode.game_id\n" +
            "left join playable_mode on game_mode.mode_id = playable_mode.id\n";

    @Query(value = "select * from game where genres like %?1% ", nativeQuery = true)
    List<Game> getGameByGenre(String genre);

    //TODO when doing description like Survive--not case sensitive in url but it is in query
    //so it doesn't query for tomb raider as well
    @Query(value = "select * from game where title like %?1% or description like %?2%", nativeQuery = true)
    List<Game> getGames(String title, String description);

    @Query(value = "select id from game where title = ?1", nativeQuery = true)
    Integer getGameIdByTitle(String title);

    @Query(value = "select * from game where title = ?1", nativeQuery = true)
    Game getGameByTitle(String title);

    @Query(value = "select * from game where title like %?1%", nativeQuery = true)
    List<Game> getGamesByTitle(String title);

    @Query(value = full_table + "where title like %?1% or genre like %?1% or description like %?1%", nativeQuery = true)
    List<Game> getGameByKeywords(String key);

    @Query(value = full_table + "where title like %?1% or genre like %?1% or description like %?1% and is_checked_out = ?2", nativeQuery = true)
    List<Game> getGameByKeywords(String key, Boolean checkedOut);



}
