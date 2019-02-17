package com.smith.gamingLab.controller;

import com.smith.gamingLab.service.ConsoleService;
import com.smith.gamingLab.service.GameService;
import com.smith.gamingLab.service.GenreService;
import com.smith.gamingLab.service.PlayableModeService;
import com.smith.gamingLab.table.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//TODO add in functionality for delete
//TODO rating?? make into table as well??

//TODO create AdminController--> add and delete games/other objects
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

    private void savePlayableModes(Game g, String mode) {
        if ( mode != null) {
            List<PlayableMode> modes = playableModeService.getPlayableModes(mode, ",");
            playableModeService.saveMapping(g, modes);
        }
    }

    //TODO put in @Nullable for all nullable fields
    //TODO just fill all fields (checkedout, digital, etc...

    //TODO value too long for description
//    @GetMapping("/addGame")
    @PostMapping("/addGame")
    private void addGame(@RequestParam(value = "title") String title, @RequestParam(value = "desc", required = false) String description,
                        @RequestParam(value = "genre",required = false) String genreTitle,
                         @RequestParam(value = "console",required = false) String console,
                         @RequestParam(value = "quantity", required = false) Integer quantity, @RequestParam(value = "rating", required = false) String rating,
                         @RequestParam(value = "playable mode", required = false) String mode, @RequestParam(value = "checked_out", required = false) boolean checkedOut,
                         @RequestParam(value = "digital", required = false) boolean isDigital) {
        Game g = new Game();
        g.setTitle(title.toLowerCase());
//        g.setDescription(description.toLowerCase());
        int q = quantity == null ? 1 : quantity;
        g.setQuantity(q);
        if (rating != null) { g.setRating(rating);}
        g.setIsCheckedOut(checkedOut);
        g.setIsDigital(isDigital);
        saveGenres(g, genreTitle.toLowerCase());
        saveConsoles(g, console.toLowerCase());
        savePlayableModes(g, mode.toLowerCase());
        gameService.saveOrUpdate(g);
    }

    //TODO eventually postmapping
    //TODO not doing desc yet until we can solve value too long problem
    //TODO how to make this better?
    @GetMapping("/editGame")
    private String editGame(@RequestParam int gameId, @RequestParam(value = "title", required = false) String title,
                          @RequestParam(value = "desc", required = false) String description,
                          @RequestParam(value = "genre",required = false) String genreTitle,
                          @RequestParam(value = "console",required = false) String console,
                          @RequestParam(value = "quantity", required = false) Integer quantity,
                          @RequestParam(value = "rating", required = false) String rating,
                          @RequestParam(value = "playable mode", required = false) String mode,
                          @RequestParam(value = "checked_out", required = false) boolean checkedOut,
                          @RequestParam(value = "digital", required = false) boolean isDigital) {
        Game game = gameService.getGameById(gameId);
        if (game == null) { return "Error: Game not found by ID: " + gameId;}
        if (title != null) {game.setTitle(title);}
        if (genreTitle != null) { saveGenres(game, genreTitle);}
        if (console != null) { saveConsoles(game, console);}
        if (quantity != null) {game.setQuantity(quantity);}
        if (rating != null) {game.setRating(rating);}
        if (mode != null) {savePlayableModes(game, mode);}
        if (checkedOut != game.getIsCheckedOut()) { game.setIsCheckedOut(checkedOut);}
        if (isDigital != game.getIsDigital()) { game.setIsDigital(isDigital);}
        gameService.saveOrUpdate(game);
        return "Successfully edited game: ";

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

    //TODO finish this query
    @GetMapping("/findGame")
    private List<Game> getByKey(@RequestParam String key, @RequestParam(required = false) Boolean checkedOut, @RequestParam(required = false)  String mode ) {
        return gameService.getGameByKey(key, checkedOut);
    }

    @GetMapping("/deleteGame")
    private void deleteGame(@RequestParam int gameId) {
        consoleService.deleteMappingByGameId(gameId);
        genreService.deleteMappingByGameId(gameId);
        playableModeService.deleteMappingByGameId(gameId);
        gameService.deleteGame(gameId);
    }

//    @GetMapping("/getMapping")
//    private List<PlayableMode> getMode(@RequestParam int gameId) {
//        return playableModeService.getModesByGameId(gameId);
//    }
//
//    @GetMapping("/modesmapping")
//    private List<GamePlayableModeMap> allModes() {
//        return playableModeService.getAllMapping();
//    }



}
