package com.example.myapplication;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.adapter.ContinentAdapter;
import com.example.myapplication.databinding.FragmentRVBinding;
import com.example.myapplication.fragment.ContinentFragment;
import com.example.myapplication.fragment.CountryFragment;
import com.example.myapplication.model.CityModel;
import com.example.myapplication.model.CountryModel;

import java.io.Serializable;
import java.util.ArrayList;

public class RVFragment extends Fragment implements OnItemClick {

    private FragmentRVBinding binding;
    private ContinentAdapter adapter;
    private ArrayList<Continent> continents = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRVBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        adapter = new ContinentAdapter(continents, this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            binding.getRoot().setOnCapturedPointerListener(adapter);
        }
    }

    private void loadData() {
        // Sample Data
        ArrayList<CityModel> citiesNorthAmerica = new ArrayList<>();
        citiesNorthAmerica.add(new CityModel("New York"));
        citiesNorthAmerica.add(new CityModel("Toronto"));

        ArrayList<CountryFragment> countriesNorthAmerica = new ArrayList<>();
        countriesNorthAmerica.add(new CountryModel("USA", citiesNorthAmerica));
        countriesNorthAmerica.add(new CountryModel("Canada", citiesNorthAmerica));

        continents.add(new ContinentAdapter("North America", countriesNorthAmerica));

        // Add other continents similarly
    }

    @Override
    public void onClick(int position) {
        Continent continent = continents.get(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable("continent", (Serializable) continent);
        CountryFragment fragment = new CountryFragment();
        fragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.tv_cities, fragment)
                .addToBackStack(null)
                .commit();
    }
}
