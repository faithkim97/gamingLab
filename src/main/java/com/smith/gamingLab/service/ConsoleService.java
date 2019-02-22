package com.smith.gamingLab.service;

import com.smith.gamingLab.misc.StringParser;
import com.smith.gamingLab.repository.ConsoleRepository;
import com.smith.gamingLab.repository.GameConsoleMapRepository;
import com.smith.gamingLab.table.Console;
import com.smith.gamingLab.table.Game;
import com.smith.gamingLab.table.GameConsoleMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsoleService {

    @Autowired
    ConsoleRepository consoleRepository;

    @Autowired
    GameConsoleMapRepository gameConsoleMapRepository;

    public List<Console> getConsoles(String consoleName, String token) {
        List<Console> consoles = new ArrayList<>();
        String[] parsed = StringParser.parseString(consoleName, token);
        if (parsed.length > 0) {
            Console console;
            for (String c : parsed) {
                console = consoleRepository.getConsoleByType(c);
                if (console == null) {
                    console = new Console(c);
                }
                saveConsole(console);
                consoles.add(console);
            }
        }
        return consoles;
    }


    public Optional<Console> getConsoleById(int id) {
        return consoleRepository.findById(id);
    }

    public Optional<GameConsoleMap> getMappingById(int id) {
        return gameConsoleMapRepository.findById(id);
    }

    public void saveConsole(Console console) {
         consoleRepository.save(console);
    }

    public List<Console> getAllConsoles() {
        List<Console> consoles = new ArrayList<>();
        consoleRepository.findAll().forEach(c -> consoles.add(c));
        return consoles;
    }

    public Console getConsoleByType(String consoleType) {
        return consoleRepository.getConsoleByType(consoleType);
    }

    public void saveGameConsoleMap(GameConsoleMap gameConsoleMap) {
        gameConsoleMapRepository.save(gameConsoleMap);
    }

    public void saveGameConsoleMap(Game game, List<Console> consoles) {
        consoles.forEach(c -> saveGameConsoleMap(new GameConsoleMap(game, c)));
    }

    public List<GameConsoleMap> getAllGameConsoleMapping() {
        List<GameConsoleMap> mapping = new ArrayList<>();
        gameConsoleMapRepository.findAll().forEach(gc -> mapping.add(gc));
        return mapping;
    }

    public void deleteMapping(int id) {
        gameConsoleMapRepository.deleteById(id);
    }

    public void deleteMappingByGameId(int gameId) {
        List<GameConsoleMap> maps = gameConsoleMapRepository.getMappingByGameId(gameId);
        maps.forEach(m -> deleteMapping(m.getId()));
    }

    /** Should only be used when we want to delete the console from the console table*/
    //TODO UNIT TEST
    public void deleteMappingByConsoleId(int consoleId) {
        List<GameConsoleMap> maps = gameConsoleMapRepository.getMappingByConsoleId(consoleId);
        maps.forEach(m-> deleteMapping(m.getId()));
    }

    public void deleteConsole(int consoleId) {
        deleteMappingByConsoleId(consoleId);
        consoleRepository.deleteById(consoleId);
    }

    public List<Console> getConsolesByGameId(int gameId) {
       List<Console> consoles = new ArrayList<>();
       List<GameConsoleMap> map = getMappingByGameId(gameId);
       map.forEach(m -> consoles.add(m.getConsole()));
       return consoles;
    }

    public List<Game> getGamesByConsoleId(int consoleId) {
        List<Game> games = new ArrayList<>();
        List<GameConsoleMap> map = getMappingByConsoleId(consoleId);
        map.forEach(m -> games.add(m.getGame()));
        return games;
    }

    public List<GameConsoleMap> getMappingByGameId(int gameId) {
        return gameConsoleMapRepository.getMappingByGameId(gameId);
    }

    public List<GameConsoleMap> getMappingByConsoleId(int consoleId) {
        return gameConsoleMapRepository.getMappingByConsoleId(consoleId);
    }

}
