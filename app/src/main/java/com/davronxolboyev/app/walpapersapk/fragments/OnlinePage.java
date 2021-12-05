package com.davronxolboyev.app.walpapersapk.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davronxolboyev.app.walpapersapk.R;
import com.davronxolboyev.app.walpapersapk.adapter.OnThemeAdapter;
import com.davronxolboyev.app.walpapersapk.model.ONwallpapers;

import java.util.ArrayList;
import java.util.List;

public class OnlinePage extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    List<ONwallpapers> themes;
    RecyclerView recyclerView;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_online_page, container, false);

        themes = new ArrayList<>();
        themes.add(new ONwallpapers(0, "Sport", "https://i.pinimg.com/236x/cf/70/69/cf7069ec3124dcc69b99d756019f46e5.jpg"));
        themes.add(new ONwallpapers(1, "Anime", "https://i.pinimg.com/236x/89/22/63/892263e4ac2fc640d6ac23b3b36c6209.jpg"));
        themes.add(new ONwallpapers(2, "Nature", "https://i.pinimg.com/236x/01/7d/e4/017de477cab592d65b7e6b0ea4811399.jpg"));
        themes.add(new ONwallpapers(3, "Animals", "https://i.pinimg.com/236x/06/98/e0/0698e0ea0867cc023cb6748a8c8a0525.jpg"));
        themes.add(new ONwallpapers(4, "DarkMood", "https://i.pinimg.com/236x/84/9e/43/849e43d68b1e381056da94adcdaa5ebd.jpg"));
        themes.add(new ONwallpapers(5, "Marvel", "https://i.pinimg.com/564x/36/dc/73/36dc73903f9b002e9191600dfb49d4e0.jpg"));
        themes.add(new ONwallpapers(6, "Galaxy", "https://i.pinimg.com/236x/ca/6f/cd/ca6fcd4c973692b159b1c113532a9dac.jpg"));
        themes.add(new ONwallpapers(7, "Cars", "https://i.pinimg.com/236x/0c/bd/c9/0cbdc992ba95501c9eb32b6f6c07ee85.jpg"));


        recyclerView = view.findViewById(R.id.onlineRecycler);
        OnThemeAdapter adapter = new OnThemeAdapter(this.getActivity(), themes);
        recyclerView.setAdapter(adapter);
        return view;
    }

}