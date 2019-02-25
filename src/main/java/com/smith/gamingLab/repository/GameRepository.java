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

    String selectByKeywords = "select g1.title, g1.description, g1.rating from game g1\n" +
            "left join game_console gc1 on gc1.game_id = g1.id\n" +
            "left join console c1 on c1.id = gc1.console_id\n" +
            "left join console c2 on c2.console = ?1\n" +
            "left join game_genre_map gg1 on gg1.game_id = g1.id\n" +
            "left join genre gg2 on gg2.genre ?2\n" +
            "left join game_mode gm1 on gm1.game_id = g1.id\n" +
            "left join playable_mode pm1 on pm1.id = gm1.mode_id\n" +
            "left join playable_mode pm2 on pm2.mode ?3\n" +
            "left join game g2 on g2.is_checked_out = \n" +
            "right join game g3 on g3.rating is not null";


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


//    @Query(value = "select * from game where description ?1", nativeQuery = true)
    //use full_table + where query
//    List<Game> getGameByKeywords(String key, Boolean checkedOut, Boolean isDigital, String console, int rating, String mode);
//    @Query(value = "select * from game where (?1 is null or title like %?1%)", nativeQuery = true)
    @Query(value = full_table + " where (?1 is null or game.title like %?1% or game.description like %?1% or genre like %?1%)" +
                                " and (?2 is null or game.is_checked_out = ?2) and (?3 is null or game.is_digital = ?3)" +
                                " and (?4 is null or console = ?4)", nativeQuery = true)
    List<Game> getGameByKeywords(String key, Boolean checkedOut, Boolean isDigital, String console);


}
