package com.smith.gamingLab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/game")
public class GameController {

    @GetMapping("/default")
    private String getDefault() {
        return "Default";
    }

}
