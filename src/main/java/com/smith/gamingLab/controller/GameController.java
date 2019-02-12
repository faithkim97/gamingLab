package com.smith.gamingLab.controller;

import com.smith.gamingLab.service.ConsoleService;
import com.smith.gamingLab.service.GameService;
import com.smith.gamingLab.service.GenreService;
import com.smith.gamingLab.service.PlayableModeService;
import com.smith.gamingLab.table.*;
import jdk.internal.jline.internal.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//TODO add in functionality for delete
//TODO rating?? make into table as well??
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
    private List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    private void saveGenres(Game g, String genreTitle) {
        if (genreTitle != null) {
            List<Genre> genres = genreService.getGenresByTitleToken(genreTitle, ",");
            genreService.saveGameGenreMap(g, genres);
        }
    }

    private void saveConsoles(Game g, String console) {
        if (console != null) {
            List<Console> consoles = consoleService.getConsoles(console, ",");
            consoleService.saveGameConsoleMap(g, consoles);
        }
    }

    private Game saveGame(String gameTitle) {
        Game g = gameService.getGameByTitle(gameTitle);
        if (g == null) {
            g.setTitle(gameTitle);
        }
        gameService.saveOrUpdate(g);
        return g;
    }

    //TODO expand on this for fields like genre, playable modes, etc..
    //TODO put in @Nullable for all nullable fields
    //TODO just fill all fields (checkedout, digital, etc...
    //TODO stopped working with postmappingt
    @GetMapping("/addGame")
    private void addGame(@RequestParam String title, @Nullable @RequestParam(required = false) String genreTitle, @RequestParam(required = false) String console,
                         @RequestParam(required = false) String description, @RequestParam(required = false) Integer quantity, @RequestParam(required = false) String rating
                         ) {
        Game g = new Game();
        g.setTitle(title);
        g.setDescription(description);
        if ( quantity != null) {
            g.setQuantity(quantity);
        }
        if (rating != null) { g.setRating(rating);}
        saveGenres(g, genreTitle);
        saveConsoles(g, console);
        gameService.saveOrUpdate(g);
    }

    @GetMapping("/addConsole")
    private List<Console> addConsole(@RequestParam String name) {
        Console c = new Console();
        c.setConsole(name);
        consoleService.saveConsole(c);
        return getConsoles();
    }


    @GetMapping("/consoles")
    private List<Console> getConsoles() {
        return consoleService.getAllConsoles();
    }

    @GetMapping("/mapConsole")
    private void addConsoleByGame(@RequestParam String gameTitle, @RequestParam String console) {
        Game g = saveGame(gameTitle);
        saveGenres(g, console);
    }

    @GetMapping("/game_console")
    private List<GameConsoleMap> getGameConsoleMap() {
        return consoleService.getAllGameConsoleMapping();
    }

    //TODO tried to do @PostMapping but got a whitelist error
    @GetMapping("/mapGenre")
    private List<GameGenreMap> addGenrebyGame(@RequestParam String gameTitle, @RequestParam String genreTitle) {
        Game game = saveGame(gameTitle);
        saveGenres(game, genreTitle);
        return getAllGameGenres();
    }

    @GetMapping("/addGenre")
    private List<Genre> addGenre(@RequestParam String genre) {
        Genre g = new Genre(genre);
        genreService.saveGenre(g);
        return getAllGenres();
    }

    @GetMapping("/genres")
    private List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    @GetMapping("/game_genre")
    private List<GameGenreMap> getAllGameGenres() {
        return genreService.getAllGameGenreMap();
    }

    @GetMapping("/addMode")
    private void addPlayableMode(@RequestParam String mode) {
        PlayableMode m = new PlayableMode(mode);
        playableModeService.savePlayableMode(m);
    }

    @GetMapping("/mapMode")
    private void mapPlayableMode(@RequestParam String gameName, @RequestParam String modeName) {
        PlayableMode p = playableModeService.getPlayableModeByTitle(modeName);
        Game game = saveGame(gameName);
        if (p == null) {
            p = new PlayableMode(modeName);
        }

        playableModeService.saveMapping(new GamePlayableModeMap(game, p));
    }

    @GetMapping("/modes")
    private List<PlayableMode> getAllModes() {
        return playableModeService.getAllPlayableModes();
    }

    @GetMapping("/game_modes")
    private List<GamePlayableModeMap> getAllPlayableModeMapping() {
        return playableModeService.getAllMapping();
    }

    @GetMapping("/findGame")
    private List<Game> getByKey(@RequestParam String key, @RequestParam(required = false) Boolean checkedOut, @RequestParam(required = false)  String mode ) {
        return gameService.getGameByKey(key, checkedOut);
    }


}
