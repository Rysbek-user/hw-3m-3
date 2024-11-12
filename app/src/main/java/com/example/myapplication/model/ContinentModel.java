package com.example.myapplication.model;

import java.io.Serializable;
import java.util.ArrayList;

public class ContinentModel implements Serializable {
    String name;
    ArrayList<CountryModel> countries;

    public ContinentModel(String name, ArrayList<CountryModel> countries) {
        this.name = name;
        this.countries = countries;
    }

    public String getName() {
        return name;
    }

    public ArrayList<CountryModel> getCountries() {
        return countries;
    }
}
