package com.smith.gamingLab.controller;

import com.smith.gamingLab.service.*;
import com.smith.gamingLab.table.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path="/game")
public class GameController {

    @Autowired
    GameService gameService;

    @Autowired
    ConsoleService consoleService;

    @Autowired
    GenreService genreService;

    @Autowired
    PlayableModeService playableModeService;

    @GetMapping("/games")
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/consoles")
    public List<Console> getConsoles() {
        return consoleService.getAllConsoles();
    }

    @GetMapping("/game_console")
    public List<GameConsoleMap> getGameConsoleMap() {
        return consoleService.getAllGameConsoleMapping();
    }

    @GetMapping("/genres")
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    @GetMapping("/game_genre")
    public List<GameGenreMap> getAllGameGenres() {
        return genreService.getAllGameGenreMap();
    }


    @GetMapping("/modes")
    public List<PlayableMode> getAllModes() {
        return playableModeService.getAllPlayableModes();
    }

    @GetMapping("/game_modes")
    public List<GamePlayableModeMap> getAllPlayableModeMapping() {
        return playableModeService.getAllMapping();
    }

//    @GetMapping("/findGame")
//    public List<Game> getByKey(@RequestParam(required = false) String key, @RequestParam(required = false) Boolean checkedOut,
//                                @RequestParam(required = false)  String mode, @RequestParam(required = false) String console,
//                                @RequestParam(required = false) boolean isDigital, @RequestParam(required = false) String rating ) {
//        return gameService.getGameByKey(key, checkedOut, isDigital, console, mode, rating);
//    }

    @GetMapping("/findGame")
    public List<MasterGame> getMasterGamesByKey(@RequestParam(required = false) String key, @RequestParam(required = false) Boolean checkedOut,
                               @RequestParam(required = false)  String mode, @RequestParam(required = false) String console,
                               @RequestParam(required = false) boolean isDigital, @RequestParam(required = false) String rating ) {
        return gameService.getMasterGameByKey(key, checkedOut, isDigital, console, mode, rating);
    }



}
