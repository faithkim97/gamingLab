package com.smith.gamingLab.table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Console {
    @GeneratedValue
    @Id
    private int id;

    private String console;

    public Console() {}

    public int getId() { return id; }

    public String getConsole() { return console; }

    public void setConsole(String console) { this.console = console; }

    public void setId(int id) { this.id = id; }
}
