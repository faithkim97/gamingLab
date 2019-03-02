package com.smith.gamingLab.table;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "master_game")
public class MasterGame {

    @GeneratedValue
    @Id
    private int id;


}
