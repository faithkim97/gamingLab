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


    @GetMapping("/default")
    private String getDefault() {
        return "Default";
    }

    @GetMapping("/games")
    private List<Game> getAllGames() {
        return gameService.getAllGames();
    }

//    @GetMapping("/addGame/{title}{console}-{description}-{quantity}-{rating}")
//    private void addGame(@PathVariable("title") String title, @PathVariable("console") String console,
//                         @PathVariable("description") String d, @PathVariable("quantity") Integer q,
//                         @PathVariable("rating") String rating) {
//        Game g = new Game();
//        g.setTitle(title);
//        g.setConsoleType(console);
//        g.setDescription(d);
//        g.setQuantity(q);
//        g.setRating(rating);
//
//    }

    @GetMapping("/addGame")
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
        //TODO how to use converter??
        //TODO Maybe get rid of converter??
        Game g  = new Game();
        List<GenreType> genreList = new ArrayList<>();
        Arrays.asList(genres.split(",")).forEach(genre -> genreList.add(GenreType.getGenreByText(genre)));
        g.setGenres(genreList);
        gameService.saveOrUpdate(g);
    }


    @GetMapping("/addGame/{title}")
    private void addGameByTitle(@PathVariable("title") String title) {
        Game g = new Game();
        g.setTitle(title);
        gameService.saveOrUpdate(g);
    }

}
