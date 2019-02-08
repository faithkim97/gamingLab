package com.smith.gamingLab.controller;

import com.smith.gamingLab.Converter.GenreTypeListToStringConverter;
import com.smith.gamingLab.constant_enum.GenreType;
import com.smith.gamingLab.service.ConsoleService;
import com.smith.gamingLab.service.GameService;
import com.smith.gamingLab.table.Console;
import com.smith.gamingLab.table.Game;
import com.smith.gamingLab.table.GameConsoleMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path="/game")
public class GameController {

    @Autowired
    GameService gameService;

    @Autowired
    ConsoleService consoleService;


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
        g.setConsoleType(console);
        g.setDescription(description);
        g.setQuantity(q);
        g.setRating(rating);
        gameService.saveOrUpdate(g);
    }

//    @GetMapping("addGameGenres")
//    private void addGame(@RequestParam String genres) {
//        Game g  = new Game();
//        List<GenreType> genreList = new GenreTypeListToStringConverter().convertToEntityAttribute(genres);
//        g.setGenres(genreList);
//        gameService.saveOrUpdate(g);
//    }


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

    //TODO don't do this by id. Do it by game
    @GetMapping("/mapConsole")
    private void addConsoleByGame(@RequestParam String gameTitle, @RequestParam String console) {
        Game g = gameService.getGameByTitle(gameTitle);
        Console c = consoleService.getConsoleByType(console);
        consoleService.saveGameConsoleMap(new GameConsoleMap(g, c));
    }

}
