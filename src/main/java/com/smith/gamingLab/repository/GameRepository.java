package com.smith.gamingLab.repository;

import com.smith.gamingLab.constant_enum.Rating;
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


    //TODO when doing description like Survive--not case sensitive in url but it is in query
    //so it doesn't query for tomb raider as well
    @Query(value = "select * from game where title like %?1% or description like %?2%", nativeQuery = true)
    List<Game> getGames(String title, String description);

    @Query(value = "select id from game where title = ?1", nativeQuery = true)
    Integer getGameIdByTitle(String title);

    //TODO this needs to be a List<Game>
    @Query(value = "select * from game where title = ?1", nativeQuery = true)
    List<Game> getGamesByExactTitle(String title);

    @Query(value = "select * from game where title like %?1%", nativeQuery = true)
    List<Game> getGamesByTitle(String title);


    //TODO query doesn't work
    @Query(value = full_table + "where (?1 is null or game.title like %?1%) or (?1 is null or genre.genre like %?1%) or (?1 is null or game.description like %?1%) and game.is_checked_out = ?2 "
            +"and game.is_digital = ?3 and (?4 is null or console.console = ?4) and game.rating = ?5 and (?6 is null or playable_mode.mode = ?6)", nativeQuery = true)
    List<Game> getGameByKeywords(String key, Boolean checkedOut, Boolean isDigital, String console, int rating, String mode);


}
