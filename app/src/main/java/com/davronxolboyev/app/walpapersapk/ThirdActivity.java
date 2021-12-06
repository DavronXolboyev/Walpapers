package com.davronxolboyev.app.walpapersapk;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.davronxolboyev.app.walpapersapk.fragments.FavouritePage;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.IOException;

public class ThirdActivity extends AppCompatActivity {

    ImageView imageView;
    FloatingActionButton button, favbtn;
    int id;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Bundle bundle = getIntent().getExtras();
        id = bundle.getInt("page");
        imageView = findViewById(R.id.getImage);
        if (id == 1) {
            imageView.setImageResource(bundle.getInt("image"));
        } else if (bundle.getInt("page_d") == 2) {
            Log.d("TAG->IMAGE", "onCreate: " + bundle.getString("image_drawable"));
            imageView.setImageDrawable((Drawable) bundle.getParcelable("image_drawable"));
        } else {
            Picasso.with(this).load(bundle.getString("image")).placeholder(R.drawable.noimage).into(imageView);
        }

        button = findViewById(R.id.setImageBtn);
        favbtn = findViewById(R.id.favImageBtn);

        button.setOnClickListener(v -> changeWallpaper());

        favbtn.setOnClickListener(view -> addFavouriteImage());
    }

    private void addFavouriteImage() {
        FavouritePage.addImage(imageView.getDrawable());
        Log.d("RASM", "addFavouriteImage: " + imageView.getDrawable());
        Toast.makeText(this, "Added to favourites!", Toast.LENGTH_SHORT).show();
    }

    private void changeWallpaper() {
        Bitmap image = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        try {
            wallpaperManager.setBitmap(image);
            Toast.makeText(this, "Installed!", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}