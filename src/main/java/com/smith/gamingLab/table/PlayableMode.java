package com.smith.gamingLab.table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "playable_mode")
public class PlayableMode {

    @GeneratedValue
    @Id
    private int id;

    private String mode;

    public PlayableMode() {
        super();
    }

    public PlayableMode(String mode) {
        this.mode = mode;
    }

    public String getMode() { return mode; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public void setMode(String mode) { this.mode = mode;}

}
