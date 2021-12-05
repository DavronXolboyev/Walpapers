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
import com.davronxolboyev.app.walpapersapk.model.OFFwallpapers;

import java.util.List;

/**
 * Created by Davron Xolboyev on 27.11.2021.
 */

public class OffThemeAdapter extends RecyclerView.Adapter<OffThemeAdapter.ImagesHolder> {

    Context context;
    List<OFFwallpapers> themes;

    public OffThemeAdapter(Context context, List<OFFwallpapers> themes) {
        this.context = context;
        this.themes = themes;
    }

    @NonNull
    @Override
    public ImagesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.themes_item, parent, false);
        return new ImagesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OffThemeAdapter.ImagesHolder holder, int position) {

        holder.imageView.setImageResource(themes.get(position).getImage());
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

    public static class ImagesHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title;

        public ImagesHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.themeImg);
            title = itemView.findViewById(R.id.themeName);
        }
    }

}
