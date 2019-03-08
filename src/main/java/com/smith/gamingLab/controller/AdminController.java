package com.smith.gamingLab.controller;

import com.smith.gamingLab.service.ConsoleService;
import com.smith.gamingLab.service.GameService;
import com.smith.gamingLab.service.GenreService;
import com.smith.gamingLab.service.PlayableModeService;
import com.smith.gamingLab.table.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/admin")
public class AdminController {
    @Autowired
    GameService gameService;

    @Autowired
    ConsoleService consoleService;

    @Autowired
    GenreService genreService;

    @Autowired
    PlayableModeService playableModeService;

    @Autowired
    GameController gameController;

    @PostMapping("/addGame")
    private void addGame(@RequestParam(value = "title") String title, @RequestParam(value = "desc", required = false) String description,
                         @RequestParam(value = "genre",required = false) String genreTitle,
                         @RequestParam(value = "console",required = false) String console,
                         @RequestParam(value = "quantity", required = false) Integer quantity, @RequestParam(value = "rating", required = false) String rating,
                         @RequestParam(value = "playable mode", required = false) String mode, @RequestParam(value = "checked_out", required = false) boolean checkedOut,
                         @RequestParam(value = "digital", required = false) boolean isDigital) {
        Game g = new Game();
        g.setTitle(title.toLowerCase());
        g.setDescription(description.toLowerCase());
        int q = quantity == null ? 1 : quantity;
        g.setQuantity(q);
        if (rating != null) { g.setRating(rating);}
        g.setIsCheckedOut(checkedOut);
        g.setIsDigital(isDigital);
        saveGenres(g, genreTitle.toLowerCase());
        saveConsoles(g, console.toLowerCase());
        savePlayableModes(g, mode.toLowerCase());
        gameService.saveOrUpdate(g);
        saveMasterGame(g);
    }

    private void saveMasterGame(Game game) {
        MasterGame masterGame = new MasterGame(game);
        int gameId = game.getId();
        List<Genre> genres = genreService.getGenresByGameId(gameId);
        List<PlayableMode> modes = playableModeService.getModesByGameId(gameId);
        List<GameConsoleMap> consoleMap = consoleService.getMappingByGameId(gameId);
        masterGame.setGenres(genres);
        masterGame.setModes(modes);
        masterGame.setConsoleMap(!consoleMap.isEmpty() ? consoleMap.get(0) : null);
        gameService.saveMasterGame(masterGame);
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
        Optional<Game> gameO = gameService.getGameById(gameId);
        if (!gameO.isPresent()) { return "Error: Game not found by ID: " + gameId;}
        Game game = gameO.get();
        if (title != null) {game.setTitle(title);}
        if (quantity != null) {game.setQuantity(quantity);}
        if (rating != null) {game.setRating(rating);}
        if (mode != null) {savePlayableModes(game, mode);}
        if (checkedOut != game.getIsCheckedOut()) { game.setIsCheckedOut(checkedOut);}
        if (isDigital != game.getIsDigital()) { game.setIsDigital(isDigital);}
        saveGenres(game, genreTitle);
        saveConsoles(game, console);
        gameService.saveOrUpdate(game);
        saveMasterGame(game);
        return "Successfully edited game: ";

    }

    @GetMapping("/addConsole")
    private List<Console> addConsole(@RequestParam String name) {
        Console c = new Console();
        c.setConsole(name);
        consoleService.saveConsole(c);
        return gameController.getConsoles();
    }

    @GetMapping("/mapConsole")
    private List<MasterGame> addConsoleByGame(@RequestParam String gameTitle, @RequestParam String console) {
        List<Game> games = saveGame(gameTitle);
        for (Game g : games) {
            saveConsoles(g, console);
            saveMasterGame(g);
        }
        return gameController.getAllGames();
    }

    @GetMapping("/mapGenre")
    private List<GameGenreMap> addGenrebyGame(@RequestParam String gameTitle, @RequestParam String genreTitle) {
        List<Game> games = saveGame(gameTitle);
        for (Game g : games) {
            saveGenres(g, genreTitle);
            saveMasterGame(g);
        }
        return gameController.getAllGameGenres();
    }

    @GetMapping("/addGenre")
    private List<Genre> addGenre(@RequestParam String genre) {
        Genre g = new Genre(genre);
        genreService.saveGenre(g);
        return gameController.getAllGenres();
    }



    @GetMapping("/addMode")
    private void addPlayableMode(@RequestParam String mode) {
        PlayableMode m = new PlayableMode(mode);
        playableModeService.savePlayableMode(m);
    }

    @GetMapping("/mapMode")
    private List<MasterGame> mapPlayableMode(@RequestParam String gameName, @RequestParam String modeName) {
        List<Game> games = saveGame(gameName);
        for (Game g : games) {
            savePlayableModes(g, modeName);
            saveMasterGame(g);
        }
        return gameController.getAllGames();
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

    private List<Game> saveGame(String gameTitle) {
        List<Game> games = gameService.getGameByTitle(gameTitle);
        if (games == null || games.isEmpty()) {
            games = new ArrayList<>();
            games.add(new Game(gameTitle));
        }
        games.forEach(g -> gameService.saveOrUpdate(g));
        return games;
    }

    private void savePlayableModes(Game g, String mode) {
        if ( mode != null) {
            List<PlayableMode> modes = playableModeService.getPlayableModes(mode, ",");
            playableModeService.saveMapping(g, modes);
        }
    }

    //TODO delete mapping for master game

    @GetMapping("/deleteGame")
    private void deleteGame(@RequestParam int gameId) {
        genreService.deleteMappingByGameId(gameId);
        playableModeService.deleteMappingByGameId(gameId);
        gameService.deleteMasterGameByGameId(gameId);
        consoleService.deleteMappingByGameId(gameId);
        gameService.deleteGame(gameId);
    }

    @GetMapping("/deleteConsole")
    private void deleteConsole(@RequestParam int consoleId) {
        List<GameConsoleMap> consoleMap = consoleService.getMappingByConsoleId(consoleId);
        gameService.deleteConsoleMap(consoleMap);
        consoleService.deleteMappingByConsoleId(consoleId);
        consoleService.deleteConsole(consoleId);
    }

    @GetMapping("/deleteGenre")
    private void deleteGenre(@RequestParam int genreId) {
        Optional<Genre> genreO = genreService.getGenreById(genreId);
        if (genreO != null) {
            deleteMasterGame(genreO.get());
        }
        genreService.deleteMappingByGenreId(genreId);
        genreService.deleteGenre(genreId);
    }

    private void deleteMasterGame(Genre genre) {
        List<MasterGame> masterGames = gameService.getMasterGamesByGenre(genre);
        for (MasterGame g : masterGames) {
            List<Genre> genres = g.getGenres();
            //TODO doesn't query for all of them
//            genres.removeIf(e -> e.getGenre().equals(genre.getGenre()));
            genres = genres.stream().filter(e -> !e.getGenre().replace(" ", "").equals(genre.getGenre().replace(" ", ""))).collect(Collectors.toList());
            g.setGenres(genres);
            gameService.saveMasterGame(g);
        }

    }


    //TODO delete playable mode
    @GetMapping("/deleteMode")
    private List<PlayableMode> deleteMode(@RequestParam int modeId) {
        playableModeService.deleteMappingByModeId(modeId);
        playableModeService.deletePlayableMode(modeId);
        return gameController.getAllModes();
    }
}//endclass
