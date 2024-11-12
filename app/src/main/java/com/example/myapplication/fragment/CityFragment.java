package com.example.myapplication.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.model.CityModel;
import com.example.myapplication.R;
import com.example.myapplication.adapter.CityAdapter;
import com.example.myapplication.model.CountryModel;

import java.util.ArrayList;

public class CityFragment extends Fragment {

    private RecyclerView recyclerView;
    private CityAdapter adapter;
    private ArrayList<CityModel> cities;

    @SuppressLint("WrongViewCast")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_city, container, false);
        recyclerView = view.findViewById(R.id.tv_cities);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        if (getArguments() != null) {
            CountryModel country = (CountryModel) getArguments().getSerializable("country");
            cities = country.getCities();
            adapter = new CityAdapter(cities);
            recyclerView.setAdapter(adapter);
        }

        return view;
    }
}
