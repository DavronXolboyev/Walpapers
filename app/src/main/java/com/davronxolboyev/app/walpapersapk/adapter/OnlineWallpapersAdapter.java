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
import com.davronxolboyev.app.walpapersapk.ThirdActivity;
import com.davronxolboyev.app.walpapersapk.model.ONwallpapers;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Davron Xolboyev on 01.12.2021.
 */

public class OnlineWallpapersAdapter extends RecyclerView.Adapter<OnlineWallpapersAdapter.WallpaperHolder> {

    Context context;
    List<ONwallpapers> list;


    public OnlineWallpapersAdapter(Context context, List<ONwallpapers> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public WallpaperHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.images_item, parent, false);
        return new WallpaperHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OnlineWallpapersAdapter.WallpaperHolder holder, int position) {

        Picasso.with(context).load(list.get(position).getImage())
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .placeholder(R.drawable.noimage).into(holder.imageView);

        holder.imageView.setOnClickListener(view -> {

            Intent intent = new Intent(context, ThirdActivity.class);
            intent.putExtra("image", list.get(position).getImage());
            intent.putExtra("id", list.get(position).getId());
            intent.putExtra("page", 2);
            context.startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class WallpaperHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public WallpaperHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.wallpaper);
        }
    }

}
