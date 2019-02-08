package com.smith.gamingLab.controller;

import com.smith.gamingLab.Converter.GenreTypeListToStringConverter;
import com.smith.gamingLab.constant_enum.GenreType;
import com.smith.gamingLab.service.GameService;
import com.smith.gamingLab.table.Game;
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


    //TODO idk how to get around the list of genre stuff...
    @GetMapping("/games")
    private List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/getGames")
    private List<Game> getGamesBy(@RequestParam String title, @RequestParam String description) {
        return gameService.getGameByFields(title, description);
    }



    //TODO made this a postmapping
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

    @GetMapping("addGameGenres")
    private void addGame(@RequestParam String genres) {
        Game g  = new Game();
        List<GenreType> genreList = new GenreTypeListToStringConverter().convertToEntityAttribute(genres);
        g.setGenres(genreList);
        gameService.saveOrUpdate(g);
    }


    @GetMapping("/addGame/{title}")
    private void addGameByTitle(@PathVariable("title") String title) {
        Game g = new Game();
        g.setTitle(title);
        gameService.saveOrUpdate(g);
    }

//    @GetMapping("/getGame")
//    private List<Game> getGamebyGenre(@RequestParam String genre){
//        return gameService.getGameByGenre(genre);
//    }

}
