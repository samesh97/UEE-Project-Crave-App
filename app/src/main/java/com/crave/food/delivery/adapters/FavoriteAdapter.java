package com.crave.food.delivery.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.crave.food.delivery.FavoriteHolder;
import com.crave.food.delivery.R;
import com.crave.food.delivery.fragments.OffersFragment;
import com.crave.food.delivery.listeners.OnCategoryClicked;
import com.crave.food.delivery.models.Favorite;

import java.util.ArrayList;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteHolder>{

    OffersFragment c;
    ArrayList<Favorite> models;

    public FavoriteAdapter(OffersFragment c, ArrayList<Favorite> models) {
        this.c = c;
        this.models = models;
    }
    public FavoriteAdapter( ArrayList<Favorite> models) {

        this.models = models;
    }

    public FavoriteAdapter(Context context, ArrayList<Favorite> models, OnCategoryClicked onCategoryClicked) {
    }

    @NonNull
    @Override
    public FavoriteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_row,null);
        return new FavoriteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteHolder holder, int position) {

        holder.favTitle.setText(models.get(position).getTitle());
        holder.favDis.setText(models.get(position).getDiscription());
        holder.favIcon.setImageResource(models.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
