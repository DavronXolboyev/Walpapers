package com.davronxolboyev.app.walpapersapk.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davronxolboyev.app.walpapersapk.R;
import com.davronxolboyev.app.walpapersapk.adapter.FavouriteAdapter;

import java.util.ArrayList;
import java.util.List;

public class FavouritePage extends Fragment {

    static List<Drawable> favourites = new ArrayList();
    static RecyclerView recyclerView;
    static FavouriteAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourite_page, container, false);


        recyclerView = view.findViewById(R.id.favRecycler);
        showImages();
        return view;
    }

    public static void addImage(Drawable drawable) {
        Log.d("Size", "addImage: " + favourites.size());
        boolean b = true;
        if (!favourites.isEmpty()){
            for (int i = 0; i < favourites.size(); i++) {
                if (drawable.equals(favourites.get(i)))
                {
                    b = false;
                    break;
                }
            }
        }
        if (b){
            favourites.add(drawable);
        }
        Log.d("Size2", "addImage: " + favourites.size());

    }

    public static void showImages() {
        if (!favourites.isEmpty()) {
            for (Drawable d : favourites) {
                Log.d("DRAWABLES", "" + d);
            }
            adapter = new FavouriteAdapter(recyclerView.getContext(), favourites);
            recyclerView.setAdapter(adapter);
        }
    }
}