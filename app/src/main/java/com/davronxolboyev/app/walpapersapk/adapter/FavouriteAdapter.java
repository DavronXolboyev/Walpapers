package com.davronxolboyev.app.walpapersapk.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.davronxolboyev.app.walpapersapk.R;

import java.util.List;

/**
 * Created by Davron Xolboyev on 04.12.2021.
 */
public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.FavouriteHolder> {

    Context context;
    List<Drawable> list;

    public FavouriteAdapter(Context context, List<Drawable> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public FavouriteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FavouriteHolder(LayoutInflater.from(context).inflate(R.layout.images_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteHolder holder, int position) {
        holder.imageView.setImageDrawable(list.get(position));
//        holder.imageView.setOnClickListener(view -> {
//            Intent intent = new Intent(context, ThirdActivity.class);
//            intent.putExtra("image_drawable", (Parcelable) holder.imageView.getDrawable());
//            intent.putExtra("page_d", 2);
//            context.startActivity(intent);
//        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class FavouriteHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public FavouriteHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.wallpaper);
        }
    }
}
