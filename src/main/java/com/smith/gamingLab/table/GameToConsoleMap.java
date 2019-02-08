package com.smith.gamingLab.table;

import javax.persistence.*;

@Entity
@Table(name = "game_console")
public class GameToConsoleMap {

    @GeneratedValue
    @Id
    private int id;

    @ManyToOne
    private Game game;

    @ManyToOne
    private Console console;

    public GameToConsoleMap() {}

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
