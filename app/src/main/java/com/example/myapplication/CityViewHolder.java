package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.model.CityModel;

public class CityViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;

    public CityViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.tv_cities);
    }

    public void bind(CityModel city) {
        textView.setText(city.getName());
    }
}
