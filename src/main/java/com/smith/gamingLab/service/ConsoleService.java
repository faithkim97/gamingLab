package com.smith.gamingLab.service;

import com.smith.gamingLab.repository.ConsoleRepository;
import com.smith.gamingLab.table.Console;
import com.smith.gamingLab.table.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsoleService {

    @Autowired
    ConsoleRepository consoleRepository;

    //TODO consolidate game to console mapping repo here as well

    public Console gameConsoleById(int id) {
        return consoleRepository.findById(id).get();
    }

    public void saveOrUpdate(Console console) {
        consoleRepository.save(console);
    }

    public List<Console> getAllConsoles() {
        List<Console> consoles = new ArrayList<>();
        consoleRepository.findAll().forEach(c -> consoles.add(c));
        return consoles;
    }

}
