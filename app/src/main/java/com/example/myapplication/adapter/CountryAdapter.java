package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.CountryViewHolder;
import com.example.myapplication.OnItemClick;
import com.example.myapplication.model.CountryModel;
import com.example.myapplication.R;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryViewHolder> {

    private ArrayList<CountryModel> countries;
    private OnItemClick onItemClick;

    public CountryAdapter(ArrayList<CountryModel> countries, OnItemClick onItemClick) {
        this.countries = countries;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CountryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.bind(countries.get(position));
        holder.itemView.setOnClickListener(v -> onItemClick.onClick(position));
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }
}
