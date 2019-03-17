package com.smith.gamingLab.table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Console {
    @GeneratedValue
    @Id
    private Integer id;

    private String console;

    public Console() {
        super();
    }

    public Console(String console) {
        this.console = console;
    }

    public String getConsole() { return console; }

    public void setConsole(String console) { this.console = console; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }
}
