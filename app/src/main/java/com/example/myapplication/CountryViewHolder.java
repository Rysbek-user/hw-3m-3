package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.model.CountryModel;

public class CountryViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;

    public CountryViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.rv_country);
    }

    public void bind(CountryModel country) {
        textView.setText(country.getName());
    }
}
