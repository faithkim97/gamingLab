package com.smith.gamingLab.repository;

import com.smith.gamingLab.table.MasterGame;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MasterGameRepository extends CrudRepository<MasterGame, Integer> {


    String fullTable = "select * from master_game \n" +
            "left join game on game.id = game_id\n" +
            "left join game_console on game_console.id = console_map_id\n" +
            "left join game_genre on game_genre.id = genre_map_id\n" +
            "left join game_mode on game_mode.id = mode_map_id\n" +
            "left join console on console.id = game_console.console_id\n" +
            "left join genre on genre.id = game_genre.genre_id\n" +
            "left join playable_mode on playable_mode.id = game_mode.mode_id";

    @Query(value = fullTable +" where (:key is null or game.title like %:key% or game.description like %:key% or genre like %:key%)" +
            " and ( :checkedOut is null or game.is_checked_out = :checkedOut) and (:isDigital is null or game.is_digital = :isDigital)" +
            " and (:consoleId is null or console.id = :consoleId) and (:modeId is null or playable_mode.id = :modeId)"+
            " and (:rating is null or rating = :rating) order by game.id", nativeQuery = true)
    List<MasterGame> getGamesByKeyword(String key, Boolean checkedOut, Boolean isDigital, Integer consoleId, Integer modeId, Integer rating);

//    @Query(value = fullTable + " where game.title = '$1'", nativeQuery = true)
//    List<MasterGame> getGamesByKeyword(String key, Boolean checkedOut, Boolean isDigital, Integer consoleId, Integer modeId, Integer rating);

    @Query(value = "select id from master_game where game_id = ?1", nativeQuery = true)
    List<Integer> getMasterGameByGameId(int gameId);

    @Query(value = "select * from master_game where console_map_id = ?1",nativeQuery = true)
    List<MasterGame> getMasterGamesByConsoleMap(int consoleMapId);

    @Query(value = "select * from master_game where genres like %?1%", nativeQuery = true)
    List<MasterGame> getMasterGamesByGenre(String genre);

    @Query(value = "select * from master_game where modes like %?1%", nativeQuery = true)
    List<MasterGame> getMasterGamesByMode(String mode);

    @Query(value = "select * from master_game where genre_map_id = ?1", nativeQuery = true)
    List<MasterGame> getMasterGamesByGenreMap(int genreId);

    @Query( value = "select * from master_game where mode_map_id = ?1", nativeQuery = true)
    List<MasterGame> getMasterGamesByModeMap(int modeId);

    @Query(value = "select * from master_game where game_id = ?1", nativeQuery = true)
    List<MasterGame> getMasterGamesByGameId(int gameId);



}
