package com.smith.gamingLab.service;

import com.smith.gamingLab.Misc.StringParser;
import com.smith.gamingLab.repository.ConsoleRepository;
import com.smith.gamingLab.repository.GameConsoleMapRepository;
import com.smith.gamingLab.table.Console;
import com.smith.gamingLab.table.Game;
import com.smith.gamingLab.table.GameConsoleMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public Console gameConsoleById(int id) {
        return consoleRepository.findById(id).get();
    }

    public void saveConsole(Console console) {
        consoleRepository.save(console);
    }

    public List<Console> getAllConsoles() {
        List<Console> consoles = new ArrayList<>();
        consoleRepository.findAll().forEach(c -> consoles.add(c));
        return consoles;
    }

    public List<Console> getConsolesByGameId(int id) {
        return gameConsoleMapRepository.getConsolesByGameId(id);
    }
    public List<Game> getGamesByConsoleId(int id) { return gameConsoleMapRepository.getGamesByConsoleId(id);}

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

}
