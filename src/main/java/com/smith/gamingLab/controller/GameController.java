package com.smith.gamingLab.controller;

import com.smith.gamingLab.constant_enum.Rating;
import com.smith.gamingLab.misc.Query;
import com.smith.gamingLab.service.*;
import com.smith.gamingLab.table.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path="/game")
//@CrossOrigin(origins = "http://localhost:3000")
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
//    @CrossOrigin("http://localhost:3000")
    public List<MasterGame> getAllGames() {
        return gameService.getAllMasterGames();
    }


    @GetMapping("/consoles")
    @CrossOrigin(origins = "http://localhost:3000")
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
    @CrossOrigin(origins = "http://localhost:3000")
    public List<PlayableMode> getAllModes() {
        return playableModeService.getAllPlayableModes();
    }

    @GetMapping("/game_modes")
    public List<GamePlayableModeMap> getAllPlayableModeMapping() {
        return playableModeService.getAllMapping();
    }


//    @GetMapping("/findgame")
//    @CrossOrigin(origins = "http://localhost:3000")
//    public List<MasterGame> getMasterGamesByKey(@RequestParam(required = false) String key, @RequestParam(required = false) Boolean checkedOut,
//                               @RequestParam(required = false)  String mode, @RequestParam(required = false) Integer console,
//                               @RequestParam(required = false) Boolean isDigital, @RequestParam(required = false) String rating ) {
//        List<MasterGame> list = gameService.getMasterGameByKey(key, checkedOut, isDigital, console, mode, rating);
//        return list;
//    }

    @PostMapping("/findgame")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody List<MasterGame> getGame(@RequestBody Query query) {
        Game game = query.getGame();
        Rating rating = game.getRating();
        Console console = query.getConsole();
        PlayableMode mode = query.getMode();
        List<MasterGame> list =  gameService.getMasterGameByKey(query.getKeyword(), game.getIsCheckedOut(), game.getIsDigital(), console != null
               && console.getId() != -1 ? console.getId() : null, mode != null && mode.getId() != -1 ?  mode.getId() : null,
                rating != null ? rating.toString() : null);
        return list;
    }

    @GetMapping("/masterGames")
    public List<MasterGame> getMasterGames() {
        return gameService.getAllMasterGames();
    }


}
