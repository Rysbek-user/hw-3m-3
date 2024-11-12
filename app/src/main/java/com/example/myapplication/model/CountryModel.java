package com.example.myapplication.model;

import com.example.myapplication.fragment.CountryFragment;

import java.io.Serializable;
import java.util.ArrayList;

public class CountryModel extends CountryFragment implements Serializable {
    String name;
    ArrayList<CityModel> cities;

    public CountryModel(String name, ArrayList<CityModel> cities) {
        this.name = name;
        this.cities = cities;
    }

    public String getName() {
        return name;
    }

    public ArrayList<CityModel> getCities() {
        return cities;
    }
}
