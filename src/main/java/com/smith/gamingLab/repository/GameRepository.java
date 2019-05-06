package com.smith.gamingLab.repository;

import com.smith.gamingLab.constant_enum.Rating;
import com.smith.gamingLab.table.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Integer> {

    String full_table = "select * from game \n" +
            "left join game_genre on game.id = game_genre.game_id\n" +
            "left join genre on game_genre.genre_id = genre.id \n" +
            "left join game_console on game.id = game_console.game_id\n" +
            "left join console on game_console.console_id = console.id\n" +
            "left join game_mode on game.id = game_mode.game_id\n" +
            "left join playable_mode on game_mode.mode_id = playable_mode.id";

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


    @Query(value = full_table + " where (?1 is null or game.title like %?1% or game.description like %?1% or genre like %?1%)" +
                                " and (?2 is null or game.is_checked_out = ?2) and (?3 is null or game.is_digital = ?3)" +
                                " and (?4 is null or console = ?4) and (?5 is null or mode like %?5%)"+
                                " and (?6 is null or rating = ?6)", nativeQuery = true)
    List<Game> getGameByKeywords(String key, Boolean checkedOut, Boolean isDigital, String console, String mode, Integer rating);


}
