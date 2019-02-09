package com.smith.gamingLab.controller;

import com.smith.gamingLab.service.ConsoleService;
import com.smith.gamingLab.service.GameService;
import com.smith.gamingLab.service.GenreService;
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


    @GetMapping("/games")
    private List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/getGames")
    private List<Game> getGamesBy(@RequestParam String title, @RequestParam String description) {
        return gameService.getGameByFields(title, description);
    }

    @PostMapping("/addGame")
    private void addGame(@RequestParam String title, @RequestParam String console,
                         @RequestParam String description, @RequestParam Integer q, @RequestParam String rating) {
        Game g = new Game();
        g.setTitle(title);
        g.setDescription(description);
        g.setQuantity(q);
        g.setRating(rating);
//        consoleService.saveGameConsoleMap(new GameConsoleMap(g, consoleService.getConsoleByType(console)));
        gameService.saveOrUpdate(g);
    }

    @GetMapping("/addGame/{title}")
    private void addGameByTitle(@PathVariable("title") String title) {
        Game g = new Game();
        g.setTitle(title);
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
        Game g = gameService.getGameByTitle(gameTitle);
        Console c = consoleService.getConsoleByType(console);

    }

    @GetMapping("/game_console")
    private List<GameConsoleMap> getGameConsoleMap() {
        return consoleService.getAllGameConsoleMapping();
    }

    //TODO tried to do @PostMapping but got a whitelist error
    @GetMapping("/mapGenre")
    private List<GameGenreMap> addGenrebyGame(@RequestParam String gameTitle, @RequestParam String genreTitle) {
        Game game = gameService.getGameByTitle(gameTitle);
        Genre genre = genreService.getGenreByTitle(genreTitle);
        if (game == null) {
            game = new Game();
            game.setTitle(gameTitle);
            gameService.saveOrUpdate(game);
        }
        if (genre == null) {
            genre = new Genre(genreTitle);
            genreService.saveGenre(genre);
        }

        genreService.saveGameGenreMap(new GameGenreMap(game, genre));
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


}
