package com.smith.gamingLab.table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {
    @GeneratedValue
    @Id
    private int id;

    private String name;

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public Person() {}
}
