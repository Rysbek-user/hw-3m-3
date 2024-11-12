package com.example.myapplication.model;

import java.io.Serializable;

public class CityModel implements Serializable {
    String name;

    public CityModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
