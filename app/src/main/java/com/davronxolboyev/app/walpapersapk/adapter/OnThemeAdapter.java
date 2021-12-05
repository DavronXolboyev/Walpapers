package com.davronxolboyev.app.walpapersapk.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.davronxolboyev.app.walpapersapk.R;
import com.davronxolboyev.app.walpapersapk.SecondActivity;
import com.davronxolboyev.app.walpapersapk.model.ONwallpapers;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Davron Xolboyev on 05.12.2021.
 */
public class OnThemeAdapter extends RecyclerView.Adapter<OnThemeAdapter.OnThemeHolder> {

    Context context;
    List<ONwallpapers> themes;

    public OnThemeAdapter(Context context, List<ONwallpapers> themes) {
        this.context = context;
        this.themes = themes;
    }

    @NonNull
    @Override
    public OnThemeAdapter.OnThemeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.themes_item, parent, false);
        return new OnThemeAdapter.OnThemeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OnThemeAdapter.OnThemeHolder holder, int position) {

        Picasso.with(context).load(themes.get(position).getImage())
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .placeholder(R.drawable.noimage).into(holder.imageView);
        holder.title.setText(themes.get(position).getThemeName());

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, SecondActivity.class);
            intent.putExtra("id", position);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return themes.size();
    }

    public static class OnThemeHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title;

        public OnThemeHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.themeImg);
            title = itemView.findViewById(R.id.themeName);
        }
    }
}
