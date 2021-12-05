package com.davronxolboyev.app.walpapersapk.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.davronxolboyev.app.walpapersapk.R;
import com.davronxolboyev.app.walpapersapk.SecondActivity;
import com.davronxolboyev.app.walpapersapk.ThirdActivity;
import com.davronxolboyev.app.walpapersapk.model.OFFwallpapers;

import java.util.List;

/**
 * Created by Davron Xolboyev on 05.12.2021.
 */
public class OfflineWallpapersadapter extends RecyclerView.Adapter<OfflineWallpapersadapter.OFFlineHolder> {

    Context context;
    List<OFFwallpapers> list;

    public OfflineWallpapersadapter(Context context, List<OFFwallpapers> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public OFFlineHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OFFlineHolder(LayoutInflater.from(context).inflate(R.layout.images_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OFFlineHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.imageView.setOnClickListener(view -> {

            Intent intent = new Intent(context, ThirdActivity.class);
            intent.putExtra("image", list.get(position).getImage());
            intent.putExtra("id", list.get(position).getId());
            intent.putExtra("page", 1);
            context.startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class OFFlineHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public OFFlineHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.wallpaper);
        }
    }
}
