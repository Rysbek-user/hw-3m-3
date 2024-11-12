package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Continent;
import com.example.myapplication.ContinentViewHolder;
import com.example.myapplication.OnItemClick;
import com.example.myapplication.RVFragment;
import com.example.myapplication.fragment.CountryFragment;
import com.example.myapplication.model.ContinentModel;
import com.example.myapplication.R;

import java.util.ArrayList;

public class ContinentAdapter extends RecyclerView.Adapter<ContinentViewHolder> implements View.OnCapturedPointerListener {

    private String continents;
    private OnItemClick onItemClick;

    public ContinentAdapter(String continents, ArrayList<CountryFragment> onItemClick) {
        this.continents = continents;
        this.onItemClick = (OnItemClick) onItemClick;
    }

    public ContinentAdapter(ArrayList<Continent> continents, RVFragment rvFragment) {
    }

    @NonNull
    @Override
    public ContinentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContinentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_continent, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContinentViewHolder holder, int position) {
        holder.bind(continents.getChars(position));
        holder.itemView.setOnClickListener(v -> onItemClick.onClick(position));
    }

    @Override
    public int getItemCount() {
        return continents.codePointCount();
    }

    @Override
    public boolean onCapturedPointer(View view, MotionEvent event) {
        return false;
    }
}
