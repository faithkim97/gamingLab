package com.smith.gamingLab.table;

import com.smith.gamingLab.constant_enum.ConsoleType;
import com.smith.gamingLab.constant_enum.Rating;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Game {
    @GeneratedValue
    @Id
    private int id;

    private String title;

    /*TODO make genre a list of string, list of enum or just a string?
    *  Depends on query?
    * */

    private ConsoleType consoleType;
    private Rating rating;
    private boolean checkedOut;
    private int quantity;
    private String desc;
    private boolean isDigital;

    public Game() {}

    




}
