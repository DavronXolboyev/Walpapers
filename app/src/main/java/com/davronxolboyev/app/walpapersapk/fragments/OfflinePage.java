package com.davronxolboyev.app.walpapersapk.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davronxolboyev.app.walpapersapk.R;
import com.davronxolboyev.app.walpapersapk.adapter.OffThemeAdapter;
import com.davronxolboyev.app.walpapersapk.model.OFFwallpapers;

import java.util.ArrayList;
import java.util.List;

public class OfflinePage extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    RecyclerView recyclerView;

    List<OFFwallpapers> lists;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_offline_page, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);

        lists = new ArrayList<>();
        lists.add(new OFFwallpapers(0, "Sport", R.drawable.sport1));
        lists.add(new OFFwallpapers(1, "Anime", R.drawable.anime));
        lists.add(new OFFwallpapers(2, "Nature", R.drawable.nature));
        lists.add(new OFFwallpapers(3, "Animals", R.drawable.animal));
        lists.add(new OFFwallpapers(4, "DarkMood", R.drawable.darkmood));
        lists.add(new OFFwallpapers(5, "Marvel", R.drawable.marvel));
        lists.add(new OFFwallpapers(6, "Galaxy", R.drawable.galaxy));
        lists.add(new OFFwallpapers(7, "Cars", R.drawable.cars));
        lists.add(new OFFwallpapers(8, "Game", R.drawable.game1));
        lists.add(new OFFwallpapers(9, "Cartoon", R.drawable.cartoon1));

        OffThemeAdapter adapter = new OffThemeAdapter(this.getActivity(), lists);
        recyclerView.setAdapter(adapter);
        return view;
    }
}