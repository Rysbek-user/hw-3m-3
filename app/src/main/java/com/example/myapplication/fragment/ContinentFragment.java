package com.example.myapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.OnItemClick;
import com.example.myapplication.model.CityModel;
import com.example.myapplication.R;
import com.example.myapplication.adapter.ContinentAdapter;
import com.example.myapplication.model.ContinentModel;
import com.example.myapplication.model.CountryModel;

import java.util.ArrayList;

public class ContinentFragment extends Fragment implements OnItemClick {

    private RecyclerView recyclerView;
    private ContinentAdapter adapter;
    private ArrayList<ContinentModel> continents;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_continent, container, false);
        recyclerView = view.findViewById(R.id.rv_continent);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        loadData();
        adapter = new ContinentAdapter(continents, this);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void loadData() {
        // Пример данных
        ArrayList<CityModel> citiesUSA = new ArrayList<>();
        citiesUSA.add(new CityModel("New York"));
        citiesUSA.add(new CityModel("Los Angeles"));

        ArrayList<CountryModel> countriesNorthAmerica = new ArrayList<>();
        countriesNorthAmerica.add(new CountryModel("USA", citiesUSA));

        continents = new ArrayList<>();
        continents.add(new ContinentModel("North America", countriesNorthAmerica));
    }

    @Override
    public void onClick(int position) {
        ContinentModel continent = continents.get(position);
        CountryFragment fragment = new CountryFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("continent", continent);
        fragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.tv_cities, fragment)
                .addToBackStack(null)
                .commit();
    }
}
