package com.smith.gamingLab.table;

import javax.persistence.*;

@Entity
@Table(name = "game_console")
public class GameConsoleMap {

    @GeneratedValue
    @Id
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Game game;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Console console;

    public GameConsoleMap() {}

    public GameConsoleMap(Game game, Console console) {
        this.game = game;
        this.console = console;
    }

    public int getId() {
        return id;
    }

    public Game getGame() {
        return game;
    }

    public Console getConsole() {
        return console;
    }

    public void setGame(Game g) { game = g;}

    public void setConsole(Console console) {this.console = console;}



}
