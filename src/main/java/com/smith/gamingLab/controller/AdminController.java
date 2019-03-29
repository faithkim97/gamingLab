package com.smith.gamingLab.controller;

import com.smith.gamingLab.service.ConsoleService;
import com.smith.gamingLab.service.GameService;
import com.smith.gamingLab.service.GenreService;
import com.smith.gamingLab.service.PlayableModeService;
import com.smith.gamingLab.table.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
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

    final String url = "http://localhost:3000";

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

    //TODO fix this: need to take into consideration what happens when modes.size() > genres.size()
    //TODO take setocnsolemap out of the loop

    private List<MasterGame> createMasterGameList(Game game, int size1, int size2) {
        List<MasterGame> masterGames = new ArrayList<>();
        int mgSize = size1 > size2 ? size1 : size2;
        for (int i = 0; i < mgSize; i++) {
            masterGames.add(new MasterGame(game));
        }
        return masterGames;
    }

    private void setGenreMapInMasterGameList(List<MasterGame> masterGames, List<GameGenreMap> genreMap) {
        for (int i = 0; i < genreMap.size(); i++) {
            masterGames.get(i).setGenreMap(genreMap.get(i));
        }
    }

    private void setModeMapInMasterGameList(List<MasterGame> masterGames, List<GamePlayableModeMap> modeMap) {
        for (int i = 0; i < modeMap.size(); i++) {
            masterGames.get(i).setModeMap(modeMap.get(i));
        }
    }


    private void saveMasterGame(Game game) {
        int gameId = game.getId();
        List<GamePlayableModeMap> modeMap = playableModeService.getMappingByGameId(gameId);
        List<GameConsoleMap> consoleMap = consoleService.getMappingByGameId(gameId);
        List<GameGenreMap> genreMap = genreService.getMappingByGameId(gameId);

        List<MasterGame> masterGames = createMasterGameList(game, genreMap.size(), modeMap.size());
        setGenreMapInMasterGameList(masterGames, genreMap);
        setModeMapInMasterGameList(masterGames, modeMap);
        //game always has only 1 console mapped
        GameConsoleMap console = !consoleMap.isEmpty() ? consoleMap.get(0) : null;
        masterGames.forEach(mg -> mg.setConsoleMap(console));
        masterGames.forEach(mg -> gameService.saveMasterGame(mg));
    }

//
//    //TODO eventually postmapping
//    //TODO not doing desc yet until we can solve value too long problem
//    //TODO how to make this better?
//    @GetMapping("/editGame")
//    private String editGame(@RequestParam int gameId, @RequestParam(value = "title", required = false) String title,
//                            @RequestParam(value = "desc", required = false) String description,
//                            @RequestParam(value = "genre",required = false) String genreTitle,
//                            @RequestParam(value = "console",required = false) String console,
//                            @RequestParam(value = "quantity", required = false) Integer quantity,
//                            @RequestParam(value = "rating", required = false) String rating,
//                            @RequestParam(value = "playable mode", required = false) String mode,
//                            @RequestParam(value = "checked_out", required = false) boolean checkedOut,
//                            @RequestParam(value = "digital", required = false) boolean isDigital) {
//        Optional<Game> gameO = gameService.getGameById(gameId);
//        if (!gameO.isPresent()) { return "Error: Game not found by ID: " + gameId;}
//        Game game = gameO.get();
//        if (title != null) {game.setTitle(title);}
//        if (quantity != null) {game.setQuantity(quantity);}
//        if (rating != null) {game.setRating(rating);}
//        if (mode != null) {savePlayableModes(game, mode);}
//        if (checkedOut != game.getIsCheckedOut()) { game.setIsCheckedOut(checkedOut);}
//        if (isDigital != game.getIsDigital()) { game.setIsDigital(isDigital);}
//        saveGenres(game, genreTitle);
//        saveConsoles(game, console);
//        gameService.saveOrUpdate(game);
//        saveMasterGame(game);
//        return "Successfully edited game: ";
//
//    }

//    @PostMapping("/editgame")
//    private void editGame(@RequestBody @NotNull Game game) {
//        Optional<Game> oldGameO = gameService.getGameById(game.getId());
//        if (oldGameO.isPresent()) {
//            Game editGame = oldGameO.get();
//            editGame.setTitle(game.getTitle());
//            editGame.setQuantity(game);
//
//        }
//
//    }

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

    @GetMapping("/mapGenreByGameId")
    @CrossOrigin(origins = url)
    private void mapGenreByGameId(@RequestParam int gameId, @RequestParam String genreTitle) {
        Optional<Game> gameO = gameService.getGameById(gameId);
        if (gameO.isPresent()) {
            Game game = gameO.get();
            saveGenres(game, genreTitle);
            saveMasterGame(game);
        }
    }

    @GetMapping("/mapGenreByGameGenreIds")
    @CrossOrigin(origins = url)
    private void mapGenreByGameGenreIds(@RequestParam int gameId, @RequestParam List<Integer> genreIds) {
        Optional<Game> gameO = gameService.getGameById(gameId);
        if (gameO.isPresent()) {
            List<Genre> genres = new ArrayList<>();
            //TODO probs check if optional present
            genreIds.forEach(id -> genres.add(genreService.getGenreById(id).get()));
            genreService.saveGameGenreMap(gameO.get(), genres);
            saveMasterGame(gameO.get());
        }
    }

    @GetMapping("/mapModeByModeGameIds")
    @CrossOrigin(origins = "http://localhost:3000")
    private void mapModeByGameModeIds(@RequestParam int gameId, @RequestParam List<Integer> modeIds) {
        Optional<Game> gameO = gameService.getGameById(gameId);
        if (gameO.isPresent()) {
            List<PlayableMode> modes = new ArrayList<>();
            modeIds.forEach(id ->modes.add(playableModeService.getPlayableModeById(id).get()));
            playableModeService.saveMapping(gameO.get(), modes);
            saveMasterGame(gameO.get());
        }
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

    @GetMapping("/replaceConsoleMap")
    @CrossOrigin(origins = url)
    private void replaceConsoleMap(@RequestParam int mapId, @RequestParam int consoleId, @RequestParam int gameId) {
        Optional<GameConsoleMap> consoleMapO = consoleService.getMappingById(mapId);
        Game game = gameService.getGameById(gameId).get();
        Console console = consoleService.getConsoleById(consoleId).get();
        GameConsoleMap consoleMap;
        if(consoleMapO.isPresent()) {
            consoleMap = consoleMapO.get();
            consoleMap.setConsole(console);
            List<MasterGame> mg = gameService.getMasterGamesByConsoleMap(mapId);
        } else {
            consoleMap = new GameConsoleMap(game, console);
        }
        consoleService.saveGameConsoleMap(consoleMap);
        saveMasterGame(game);
    }

    @GetMapping("/deleteGame")
    private void deleteGame(@RequestParam int gameId) {
        gameService.deleteMasterGamesByGameId(gameId);
        genreService.deleteMappingByGameId(gameId);
        playableModeService.deleteMappingByGameId(gameId);
        consoleService.deleteMappingByGameId(gameId);
        gameService.deleteGame(gameId);
    }

    @GetMapping("/deleteConsole")
    private void deleteConsole(@RequestParam int consoleId) {
        List<GameConsoleMap> consoleMaps = consoleService.getMappingByConsoleId(consoleId);
        for (GameConsoleMap m : consoleMaps) {
            List<MasterGame> masterGames = gameService.getMasterGamesByConsoleMap(m.getId());
            for (MasterGame mg : masterGames) {
                mg.setConsoleMap(null);
                gameService.saveMasterGame(mg);
            }
        }
        consoleService.deleteMappingByConsoleId(consoleId);
        consoleService.deleteConsole(consoleId);
    }

    @GetMapping("/deleteGenre")
    private void deleteGenre(@RequestParam int genreId) {
        List<GameGenreMap> genreMaps = genreService.getMappingByGenreId(genreId);
        for (GameGenreMap m : genreMaps) {
            List<MasterGame> masterGames = gameService.getMasterGamesByGenreMap(m.getId());
            for (MasterGame mg : masterGames) {
                mg.setGenreMap(null);
                gameService.saveMasterGame(mg);
            }
        }
        genreService.deleteMappingByGenreId(genreId);
        genreService.deleteGenre(genreId);
    }



    @GetMapping("/deleteMode")
    private void deleteMode(@RequestParam int modeId) {
        List<GamePlayableModeMap> modeMaps = playableModeService.getMappingByModeId(modeId);
        for (GamePlayableModeMap m : modeMaps) {
            List<MasterGame> masterGames = gameService.getMasterGamesByModeMap(m.getId());
            for (MasterGame mg : masterGames) {
                mg.setModeMap(null);
                gameService.saveMasterGame(mg);
            }
        }
        playableModeService.deleteMappingByModeId(modeId);
        playableModeService.deletePlayableMode(modeId);
    }

    @GetMapping("/deleteModeMap")
    @CrossOrigin(origins = url)
    private void deleteModeMap(@RequestParam int mapId) {
        List<MasterGame> games = gameService.getMasterGamesByModeMap(mapId);
        for (MasterGame g : games) {
            g.setModeMap(null);
            gameService.saveMasterGame(g);
        }
        playableModeService.deleteMappingById(mapId);
    }

    @GetMapping("/deleteGenreMap")
    @CrossOrigin(origins = url)
    private void deleteGenreMap(@RequestParam int mapId) {
        List<MasterGame> games = gameService.getMasterGamesByGenreMap(mapId);
        for(MasterGame g : games) {
            g.setGenreMap(null);
            gameService.saveMasterGame(g);
        }
        genreService.deleteMapping(mapId);
    }

    @GetMapping("/deleteConsoleMap")
    @CrossOrigin(origins = url)
    private void deleteConsoleMap(@RequestParam int mapId) {
        List<MasterGame> games = gameService.getMasterGamesByConsoleMap(mapId);
        for(MasterGame g : games) {
            g.setConsoleMap(null);
            gameService.saveMasterGame(g);
        }
        consoleService.deleteMapping(mapId);
    }
}//endclass
