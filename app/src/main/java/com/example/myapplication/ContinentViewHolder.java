package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.model.ContinentModel;

public class ContinentViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;

    public ContinentViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.rv_continent);
    }

    public void bind(ContinentModel continent) {
        textView.setText(continent.getName());
    }
}
