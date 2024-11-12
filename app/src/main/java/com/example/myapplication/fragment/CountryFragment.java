package com.example.myapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.OnItemClick;
import com.example.myapplication.R;
import com.example.myapplication.adapter.CountryAdapter;
import com.example.myapplication.model.ContinentModel;
import com.example.myapplication.model.CountryModel;

import java.util.ArrayList;

public class CountryFragment extends Fragment implements OnItemClick {

    private RecyclerView recyclerView;
    private CountryAdapter adapter;
    private ArrayList<CountryModel> countries;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country, container, false);
        recyclerView = view.findViewById(R.id.rv_country);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        if (getArguments() != null) {
            ContinentModel continent = (ContinentModel) getArguments().getSerializable("continent");
            countries = continent.getCountries();
            adapter = new CountryAdapter(countries, this);
            recyclerView.setAdapter(adapter);
        }

        return view;
    }

    @Override
    public void onClick(int position) {
        CountryModel country = countries.get(position);
        CityFragment fragment = new CityFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("country", country);
        fragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.tv_cities, fragment)
                .addToBackStack(null)
                .commit();
    }
}
