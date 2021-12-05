package com.davronxolboyev.app.walpapersapk.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.davronxolboyev.app.walpapersapk.fragments.FavouritePage;
import com.davronxolboyev.app.walpapersapk.fragments.OfflinePage;
import com.davronxolboyev.app.walpapersapk.fragments.OnlinePage;

/**
 * Created by Davron Xolboyev on 01.12.2021.
 */
public class FragmentAdapter extends FragmentStateAdapter {
    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new OnlinePage();
            case 2:
                return new FavouritePage();
        }
        return new OfflinePage();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
