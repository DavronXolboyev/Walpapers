package com.davronxolboyev.app.walpapersapk;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.davronxolboyev.app.walpapersapk.adapter.OfflineWallpapersadapter;
import com.davronxolboyev.app.walpapersapk.adapter.OnlineWallpapersAdapter;
import com.davronxolboyev.app.walpapersapk.model.OFFwallpapers;
import com.davronxolboyev.app.walpapersapk.model.ONwallpapers;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<ONwallpapers> wallpapers;
    List<OFFwallpapers> wallpapers2;
    int id;
    String theme = "";
    public List<String> images;
    public List<Integer> images2;
    SwipeRefreshLayout refreshLayout;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        recyclerView = findViewById(R.id.wallpaperRecycler);

        Bundle bundle = getIntent().getExtras();
        id = bundle.getInt("id");
        getUrlImages(id);
        getOfflineImages(id);
        switch (id) {
            case 0:
                theme = "Sport";
                break;
            case 1:
                theme = "Anime";
                break;
            case 2:
                theme = "Nature";
                break;
            case 3:
                theme = "Animals";
                break;
            case 4:
                theme = "DarkMood";
                break;
            case 5:
                theme = "Marvel";
                break;
            case 6:
                theme = "Galaxy";
                break;
            case 7:
                theme = "Cars";
                break;
            case 8:
                theme = "Game";
                break;
            case 9:
                theme = "Cartoon";
                break;
        }
        Log.d("ID", " : " + id);
        Log.d("PAGE : ", "" + MainActivity.k);
        refreshLayout = findViewById(R.id.refreashLayout);
        switch (MainActivity.k) {
            case 0:
                offlineWallpapers();
                refreshLayout.setEnabled(false);
                break;
            case 1: {
                onlineWallpapers();
                refreshLayout.setEnabled(true);
                refreshLayout.setOnRefreshListener(() -> {
                    onlineWallpapers();
                    refreshLayout.setRefreshing(false);
                });
                break;
            }
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void onlineWallpapers() {
        Log.d("INTERNET : ", "" + isNetworkConnected());
        if (isNetworkConnected()) {
            recyclerView.setEnabled(true);
        } else {
            Toast.makeText(this, "Internet is not connected", Toast.LENGTH_LONG).show();
            recyclerView.setEnabled(false);
        }

        wallpapers = new ArrayList<>();
        for (int i = 0; i < images.size(); i++) {
            wallpapers.add(new ONwallpapers(id, theme, images.get(i)));
        }

        OnlineWallpapersAdapter adapter = new OnlineWallpapersAdapter(this, wallpapers);
        recyclerView.setAdapter(adapter);
    }

    private void offlineWallpapers() {
        wallpapers2 = new ArrayList<>();
        for (int i = 0; i < images2.size(); i++) {
            wallpapers2.add(new OFFwallpapers(id,
                    theme,
                    images2.get(i)));
        }

        OfflineWallpapersadapter wadapter = new OfflineWallpapersadapter(this, wallpapers2);
        recyclerView.setAdapter(wadapter);

    }

    private void getOfflineImages(int id) {
        images2 = new ArrayList<>();
        switch (id) {
            case 0: {
                //sport
                images2.add(R.drawable.sport1);
                images2.add(R.drawable.sport2);
                images2.add(R.drawable.sport3);
                images2.add(R.drawable.sport4);
                images2.add(R.drawable.sport5);
                images2.add(R.drawable.sport6);
                images2.add(R.drawable.sport7);
                images2.add(R.drawable.sport8);
                images2.add(R.drawable.sport9);
                images2.add(R.drawable.sport10);
                images2.add(R.drawable.sport11);
                images2.add(R.drawable.sport12);
                images2.add(R.drawable.sport13);
                images2.add(R.drawable.sport14);
                break;
            }
            case 1: {
                //anime
                images2.add(R.drawable.anime);
                images2.add(R.drawable.anime1);
                images2.add(R.drawable.anime2);
                images2.add(R.drawable.anime3);
                images2.add(R.drawable.anime4);
                images2.add(R.drawable.anime5);
                images2.add(R.drawable.anime6);
                images2.add(R.drawable.anime7);
                images2.add(R.drawable.anime8);
                images2.add(R.drawable.anime9);
                images2.add(R.drawable.anime10);
                images2.add(R.drawable.anime11);
                images2.add(R.drawable.anime12);
                images2.add(R.drawable.anime13);
                images2.add(R.drawable.anime14);
                break;
            }
            case 2: {
                //nature
                images2.add(R.drawable.nature);
                images2.add(R.drawable.nature1);
                images2.add(R.drawable.nature2);
                images2.add(R.drawable.nature3);
                images2.add(R.drawable.nature4);
                images2.add(R.drawable.nature5);
                images2.add(R.drawable.nature6);
                images2.add(R.drawable.nature7);
                images2.add(R.drawable.nature8);
                images2.add(R.drawable.nature9);
                images2.add(R.drawable.nature10);
                images2.add(R.drawable.nature11);
                images2.add(R.drawable.nature12);
                images2.add(R.drawable.nature13);
                images2.add(R.drawable.nature14);
                images2.add(R.drawable.nature15);
                images2.add(R.drawable.nature16);
                images2.add(R.drawable.nature17);
                images2.add(R.drawable.nature18);
                break;
            }
            case 3: {
                //animal
                images2.add(R.drawable.animal);
                images2.add(R.drawable.animal1);
                images2.add(R.drawable.animal2);
                images2.add(R.drawable.animal3);
                images2.add(R.drawable.animal4);
                images2.add(R.drawable.animal5);
                images2.add(R.drawable.animal6);
                images2.add(R.drawable.animal7);
                images2.add(R.drawable.animal8);
                images2.add(R.drawable.animal9);
                images2.add(R.drawable.animal10);
                images2.add(R.drawable.animal11);
                images2.add(R.drawable.animal12);
                images2.add(R.drawable.animal13);
                images2.add(R.drawable.animal14);
                images2.add(R.drawable.animal15);
                images2.add(R.drawable.animal16);
                images2.add(R.drawable.animal17);
                images2.add(R.drawable.animal18);
                images2.add(R.drawable.animal19);
                break;
            }
            case 4: {
                //dark
                images2.add(R.drawable.darkmood);
                images2.add(R.drawable.darkmood1);
                images2.add(R.drawable.darkmood2);
                images2.add(R.drawable.darkmood3);
                images2.add(R.drawable.darkmood4);
                images2.add(R.drawable.darkmood5);
                images2.add(R.drawable.darkmood6);
                images2.add(R.drawable.darkmood7);
                images2.add(R.drawable.darkmood8);
                images2.add(R.drawable.darkmood9);
                images2.add(R.drawable.darkmood10);
                break;
            }
            case 5: {
                //marvel
                images2.add(R.drawable.marvel1);
                images2.add(R.drawable.marvel2);
                images2.add(R.drawable.marvel3);
                images2.add(R.drawable.marvel4);
                images2.add(R.drawable.marvel5);
                images2.add(R.drawable.marvel6);
                images2.add(R.drawable.marvel7);
                images2.add(R.drawable.marvel8);
                images2.add(R.drawable.marvel9);
                images2.add(R.drawable.marvel10);
                images2.add(R.drawable.marvel11);
                images2.add(R.drawable.marvel12);
                images2.add(R.drawable.marvel13);
                images2.add(R.drawable.marvel14);
                images2.add(R.drawable.marvel15);
                break;
            }
            case 6: {
                //galaxy
                images2.add(R.drawable.galaxy);
                images2.add(R.drawable.galaxy1);
                images2.add(R.drawable.galaxy2);
                images2.add(R.drawable.galaxy3);
                images2.add(R.drawable.galaxy4);
                images2.add(R.drawable.galaxy5);
                images2.add(R.drawable.galaxy6);
                images2.add(R.drawable.galaxy7);
                images2.add(R.drawable.galaxy8);
                images2.add(R.drawable.galaxy9);
                images2.add(R.drawable.galaxy10);
                images2.add(R.drawable.galaxy11);
                images2.add(R.drawable.galaxy12);
                break;
            }
            case 7: {
                //cars
                images2.add(R.drawable.cars);
                images2.add(R.drawable.cars1);
                images2.add(R.drawable.cars2);
                images2.add(R.drawable.cars3);
                images2.add(R.drawable.cars4);
                images2.add(R.drawable.cars5);
                images2.add(R.drawable.cars6);
                images2.add(R.drawable.cars7);
                images2.add(R.drawable.cars8);
                images2.add(R.drawable.cars9);
                images2.add(R.drawable.cars10);
                images2.add(R.drawable.cars11);
                images2.add(R.drawable.cars12);
                break;
            }
            case 8: {
                //game
                images2.add(R.drawable.game1);
                images2.add(R.drawable.game2);
                images2.add(R.drawable.game3);
                images2.add(R.drawable.game4);
                images2.add(R.drawable.game5);
                images2.add(R.drawable.game6);
                images2.add(R.drawable.game7);
                images2.add(R.drawable.game8);
                images2.add(R.drawable.game9);
                images2.add(R.drawable.game10);
                images2.add(R.drawable.game11);
                images2.add(R.drawable.game12);
                images2.add(R.drawable.game13);
                images2.add(R.drawable.game14);
                images2.add(R.drawable.game15);
                images2.add(R.drawable.game16);
                images2.add(R.drawable.game17);
                images2.add(R.drawable.game18);
                images2.add(R.drawable.game19);
                images2.add(R.drawable.game20);
                images2.add(R.drawable.game21);
                images2.add(R.drawable.game22);
                images2.add(R.drawable.game23);
                images2.add(R.drawable.game24);
                images2.add(R.drawable.game25);
                break;
            }
            case 9: {
                //cartoon
                images2.add(R.drawable.cartoon1);
                images2.add(R.drawable.cartoon2);
                images2.add(R.drawable.cartoon3);
                images2.add(R.drawable.cartoon4);
                images2.add(R.drawable.cartoon5);
                images2.add(R.drawable.cartoon6);
                images2.add(R.drawable.cartoon7);
                images2.add(R.drawable.cartoon8);
                images2.add(R.drawable.cartoon9);
                images2.add(R.drawable.cartoon10);
                images2.add(R.drawable.cartoon12);
                break;
            }
        }
    }

    private void getUrlImages(int i) {
        images = new ArrayList<>();
        switch (i) {
            case 0: {
                //Sport
                images.add("https://i.pinimg.com/236x/cf/70/69/cf7069ec3124dcc69b99d756019f46e5.jpg");
                images.add("https://i.pinimg.com/564x/a2/c4/19/a2c419acdb619fffb58b9bb7d933aa34.jpg");
                images.add("https://i.pinimg.com/564x/e6/90/be/e690be34e8b6a1160a3c720dc5f86573.jpg");
                images.add("https://i.pinimg.com/236x/42/9f/23/429f23af9e8317843e701b33270f92cf.jpg");
                images.add("https://i.pinimg.com/564x/c2/ee/74/c2ee7489bbb113d4bcf67f5c5329cd87.jpg");
                images.add("https://i.pinimg.com/564x/36/b3/5c/36b35ce02cad6f77a94ca1ad01e80a77.jpg");
                images.add("https://i.pinimg.com/564x/39/5e/4b/395e4b8ee84475827c3e10119e006ca8.jpg");
                images.add("https://i.pinimg.com/236x/99/64/60/996460523be467cdf19b70b6d7709d59.jpg");
                images.add("https://i.pinimg.com/564x/08/62/41/086241cf61c91b1a2b0bd05980283244.jpg");
                images.add("https://i.pinimg.com/564x/c5/8f/aa/c58faab867cae60d6335d3a220e82206.jpg");
                images.add("https://i.pinimg.com/564x/3d/cb/78/3dcb7847a7a7d4f0377b2f034831b28c.jpg");
                images.add("https://i.pinimg.com/564x/e6/1d/a2/e61da26e65db5a2d455a8c1fc13d9138.jpg");
                images.add("https://i.pinimg.com/564x/09/51/0b/09510b7160ccf78ebb9ad860f5158626.jpg");
                images.add("https://i.pinimg.com/564x/20/9f/6b/209f6b14f270288437fa6f5de81d6097.jpg");
                images.add("https://i.pinimg.com/564x/c4/04/5b/c4045b14a2ec10f5a06453ba361f2af4.jpg");
                images.add("https://i.pinimg.com/564x/32/87/8c/32878c94c576dcdd93a13011dd34ae43.jpg");
                images.add("https://i.pinimg.com/564x/d6/81/94/d681941f6f1a0cfdbdcdbcc799112d4c.jpg");
                images.add("https://i.pinimg.com/564x/e5/46/22/e54622fbfb044666ab7ba4c6a37bbf1b.jpg");
                images.add("https://i.pinimg.com/564x/87/d5/0f/87d50f74b04fbdc69fd12994f5c317c9.jpg");
                images.add("https://i.pinimg.com/564x/97/4b/34/974b3412b85bc63874f4d421771c525f.jpg");
                images.add("https://i.pinimg.com/564x/b4/d4/c0/b4d4c04fde437a974d9c2c4b4dfefee0.jpg");
                images.add("https://i.pinimg.com/564x/11/06/1e/11061e105b848a2489a2539fa54cf89f.jpg");
                break;
            }

            case 1: {
                //Anime
                images.add("https://i.pinimg.com/236x/89/22/63/892263e4ac2fc640d6ac23b3b36c6209.jpg");
                images.add("https://i.pinimg.com/564x/ab/c6/92/abc6925e9ea4a48bda338bff58c5e399.jpg");
                images.add("https://i.pinimg.com/564x/5f/00/6a/5f006a6bde40681eb1e74bc95c0da993.jpg");
                images.add("https://i.pinimg.com/564x/a3/4f/58/a34f58c7fc99a97ab2d34e0035e950fa.jpg");
                images.add("https://i.pinimg.com/564x/dd/cf/29/ddcf297d6f9010a6fc6219e4aba185f1.jpg");
                images.add("https://i.pinimg.com/564x/4e/f2/ae/4ef2ae6c48be683ace320d6a4ef8fd6b.jpg");
                images.add("https://i.pinimg.com/236x/0e/54/b4/0e54b4d273371b80c5d36b0df4197c3a.jpg");
                images.add("https://i.pinimg.com/236x/15/2f/96/152f964ef242cce8dea4b6accf071669.jpg");
                images.add("https://i.pinimg.com/236x/9d/cd/4d/9dcd4d700816fdd4a82f0ed43c9cf2dc.jpg");
                images.add("https://i.pinimg.com/236x/f8/60/65/f860658efa961b02d637526502980d3c.jpg");
                images.add("https://i.pinimg.com/236x/b8/97/1e/b8971e25dcfd92d83b2bd25101521ab7.jpg");
                images.add("https://i.pinimg.com/236x/ec/a6/80/eca6803373a4eb66fcc77005fd535a6e.jpg");
                images.add("https://i.pinimg.com/236x/7a/86/40/7a86407aaa7fb8644a5586c66a89d304.jpg");
                images.add("https://i.pinimg.com/236x/1d/85/7f/1d857f36cda7a6639958f6a2d79b28e1.jpg");
                images.add("https://i.pinimg.com/236x/dd/22/de/dd22deb18fd11f129a05d035b5f02c7b.jpg");
                images.add("https://i.pinimg.com/236x/97/ea/43/97ea4346701d345f54cf804ea00dc9f1.jpg");
                images.add("https://i.pinimg.com/236x/73/ad/b5/73adb55978e006039412ac20a9ef1aac.jpg");
                images.add("https://i.pinimg.com/236x/7f/6f/d1/7f6fd1a3938151cb4dcc40c3880bcda3.jpg");
                images.add("https://i.pinimg.com/236x/fb/5a/67/fb5a6719cc48c630636f0c120bef1e29.jpg");
                images.add("https://i.pinimg.com/236x/22/ed/fd/22edfde01a7aaf7dc7943acc0eb8d56c.jpg");
                images.add("https://i.pinimg.com/236x/48/c8/a7/48c8a7ce8bef3de4dba842d031941d27.jpg");
                images.add("https://i.pinimg.com/236x/b9/46/32/b946326ee75e13a1200648f86d225053.jpg");
                images.add("https://i.pinimg.com/236x/15/bc/04/15bc04bfc0f824358e48de5a6dc2238d.jpg");
                images.add("https://i.pinimg.com/236x/33/9f/d1/339fd1f8dc243a2bba36feba07a6ab38.jpg");
                images.add("https://i.pinimg.com/236x/fe/0b/11/fe0b114a76d921cab1ffee72cd089265.jpg");
                images.add("https://i.pinimg.com/236x/20/8a/14/208a14df835fd0c40228ae56c106c493.jpg");
                images.add("https://i.pinimg.com/236x/23/fa/fa/23fafaf3008c9aae0f6b2a8ca9d8034c.jpg");
                images.add("https://i.pinimg.com/236x/14/45/ee/1445eefa04dbd3ac88f342b30da84876.jpg");
                images.add("https://i.pinimg.com/236x/52/39/62/523962cb31a908a244b68e4aca476a1a.jpg");
                images.add("https://i.pinimg.com/236x/4f/5c/3c/4f5c3c41b9efbac02d448ce12a5570ab.jpg");
                images.add("https://i.pinimg.com/236x/85/aa/da/85aadaf12088145eebc6d436214c6037.jpg");
                images.add("https://i.pinimg.com/236x/54/c3/ed/54c3edcbe93394321575cea8fdcb4a5d.jpg");
                images.add("https://i.pinimg.com/236x/df/78/e1/df78e1c379c2522b87afeb53903c2b1a.jpg");
                images.add("https://i.pinimg.com/236x/f4/dd/e1/f4dde1cbd1466149e793398e833d1e2d.jpg");
                images.add("https://i.pinimg.com/236x/ee/c1/36/eec1360baad1d4ddf65ecb54b980d4c1.jpg");
                images.add("https://i.pinimg.com/236x/65/c4/ef/65c4efe12720d5cccc4e4b59c29fe170.jpg");
                images.add("https://i.pinimg.com/236x/44/8b/dd/448bdd03186bc490a3fdb3523006b09c.jpg");
                images.add("https://i.pinimg.com/236x/68/bb/e3/68bbe397d4bbdd639aa3ee415df88404.jpg");
                images.add("https://i.pinimg.com/236x/0d/b4/57/0db457255a6b49a9076b195456c3f2f9.jpg");
                images.add("https://i.pinimg.com/236x/1f/93/90/1f9390274a098d1b257b7c337f5ebf43.jpg");
                images.add("https://i.pinimg.com/236x/ab/98/a9/ab98a98bea6f8385cc024cf93540fbae.jpg");
                images.add("https://i.pinimg.com/236x/9e/c9/5a/9ec95ac2ffdc1a51bbe1b7c9803538bb.jpg");
                images.add("https://i.pinimg.com/236x/34/a2/8d/34a28d416cecc68ea1b63a226f302d63.jpg");
                images.add("https://i.pinimg.com/236x/0b/ac/24/0bac24af0844b7700e5ed15412d5373d.jpg");
                images.add("https://i.pinimg.com/236x/eb/22/ca/eb22caca5d4a4f9d13d48add25cfbec9.jpg");
                images.add("https://i.pinimg.com/236x/fe/92/a9/fe92a9678968e6a744d3d80e25910bb7.jpg");
                images.add("https://i.pinimg.com/236x/df/1e/86/df1e86fc3a363756b598a316f187c754.jpg");
                images.add("https://i.pinimg.com/236x/5a/5b/05/5a5b05add5dace0a2c1f7c0d2ff2853f.jpg");
                images.add("https://i.pinimg.com/236x/a2/1c/ae/a21cae86664c5defecd0ae3b205e5626.jpg");
                break;
            }

            case 2: {

                // Nature
                images.add("https://i.pinimg.com/236x/01/7d/e4/017de477cab592d65b7e6b0ea4811399.jpg");
                images.add("https://i.pinimg.com/236x/8f/79/81/8f7981082dd2df3a7cb46622ecfe5b05.jpg");
                images.add("https://i.pinimg.com/236x/de/d2/02/ded202a5e872ad23c49a38bd63667760.jpg");
                images.add("https://i.pinimg.com/236x/4b/4c/9b/4b4c9b72dd8fdcd902e09c17e281475c.jpg");
                images.add("https://i.pinimg.com/236x/ed/86/c2/ed86c25cc7a80e26ac998dff198fb5a3.jpg");
                images.add("https://i.pinimg.com/236x/58/16/92/581692500f611a6e70f11c648a99bad7.jpg");
                images.add("https://i.pinimg.com/236x/5c/bc/2e/5cbc2e9beee35b281acd20ef5f33ed8b.jpg");
                images.add("https://i.pinimg.com/236x/d2/b8/3d/d2b83d8c2838bba9a3474971207fd357.jpg");
                images.add("https://i.pinimg.com/236x/e2/64/c7/e264c7e698b575a1818b05787dfe64a3.jpg");
                images.add("https://i.pinimg.com/236x/b7/dd/4b/b7dd4b91a39ff8b71dcf3fd2083d2c39.jpg");
                images.add("https://i.pinimg.com/236x/79/92/21/7992215a2785539621abe660ad9b08a3.jpg");
                images.add("https://i.pinimg.com/236x/f7/54/7d/f7547d58bd2973819ed7060935308904.jpg");
                images.add("https://i.pinimg.com/236x/eb/43/8c/eb438ca124d1fc1c4c99504f3670dda7.jpg");
                images.add("https://i.pinimg.com/236x/22/f8/d6/22f8d66d51e0e73765606655fe8d6ed2.jpg");
                images.add("https://i.pinimg.com/236x/00/a4/28/00a428b3dd684cf92ca5cc9f53807558.jpg");
                images.add("https://i.pinimg.com/236x/87/ee/84/87ee84a7753d209362a78119a29ceb1d.jpg");
                images.add("https://i.pinimg.com/236x/a1/42/91/a1429158b91d9eb51dcae9896c66a2d2.jpg");
                images.add("https://i.pinimg.com/236x/3b/9b/9d/3b9b9de3e6cad8d46fb2765931858fd5.jpg");
                images.add("https://i.pinimg.com/236x/98/72/62/98726238256fbab814eed75b38923e1d.jpg");
                images.add("https://i.pinimg.com/236x/fe/5f/cd/fe5fcd2abceee23c2ff48e01c03f9a9d.jpg");
                images.add("https://i.pinimg.com/236x/6c/12/86/6c1286a1895046fdb0dd8b9ff8c5db42.jpg");
                images.add("https://i.pinimg.com/236x/a6/0e/64/a60e64c098ee31eb57ae1ab42217cc36.jpg");
                images.add("https://i.pinimg.com/236x/13/1a/5a/131a5a696b828bfe87c73075e0e0139e.jpg");
                images.add("https://i.pinimg.com/236x/23/5d/9e/235d9ec10cb745100618a963406a370d.jpg");
                images.add("https://i.pinimg.com/236x/fd/55/fd/fd55fd606b19219938415a4f58b9fa80.jpg");
                images.add("https://i.pinimg.com/236x/fb/a6/ee/fba6ee4b66430bfa0b93f63a74ebafa6.jpg");
                images.add("https://i.pinimg.com/236x/5f/4c/ce/5f4ccef0c436efdeac066c4dc162b7c1.jpg");
                images.add("https://i.pinimg.com/236x/c9/19/47/c91947785365f12c004d5ff4c7c12833.jpg");
                images.add("https://i.pinimg.com/236x/67/37/4a/67374a38f93b461811a207e94ddabbcb.jpg");
                images.add("https://i.pinimg.com/236x/1d/67/5c/1d675c531a270f52232df20a041dbe66.jpg");
                break;
            }

            case 3: {

                //Animals
                images.add("https://i.pinimg.com/236x/06/98/e0/0698e0ea0867cc023cb6748a8c8a0525.jpg");
                images.add("https://i.pinimg.com/236x/95/bb/ba/95bbba256aace1b55eca5a40e5ec75cb.jpg");
                images.add("https://i.pinimg.com/236x/36/86/6d/36866dbeeb8ba0e27c9e6fdb44274b96.jpg");
                images.add("https://i.pinimg.com/236x/a3/69/c6/a369c647c454e1869251e1177488004f.jpg");
                images.add("https://i.pinimg.com/236x/07/f1/a7/07f1a7853025c29189a3f82a2a39ff21.jpg");
                images.add("https://i.pinimg.com/236x/97/5b/0e/975b0e430fc73c1d029e10916cf72579.jpg");
                images.add("https://i.pinimg.com/236x/49/f9/c7/49f9c739407228f93417754b7be54e19.jpg");
                images.add("https://i.pinimg.com/236x/74/4c/73/744c73b6d25025ab480e0ecdc4523bf0.jpg");
                images.add("https://i.pinimg.com/236x/79/d4/61/79d461f1c8d035fd49fcaff2347e7cdd.jpg");
                images.add("https://i.pinimg.com/564x/15/96/7e/15967ed74cb2a498ff9a354615124d86.jpg");
                images.add("https://i.pinimg.com/236x/13/1e/89/131e89be9939e3edbc55cae83cfb9ddc.jpg");
                images.add("https://i.pinimg.com/236x/39/d5/04/39d504b508fd846710b1d2de42bbcf01.jpg");
                images.add("https://i.pinimg.com/564x/6b/f9/8e/6bf98e37f0ff0de7065dcded6c833602.jpg");
                images.add("https://i.pinimg.com/236x/82/f2/33/82f233ed38c6aad5b236e8215afcc575.jpg");
                images.add("https://i.pinimg.com/236x/9a/e4/ca/9ae4cae6f7992d63d031bb5a02d1de40.jpg");
                images.add("https://i.pinimg.com/236x/83/8c/dd/838cdd573c109d369ceadf69903dd9c6.jpg");
                images.add("https://i.pinimg.com/236x/cd/07/a8/cd07a8f7ddc33808ccbe25844e825cc4.jpg");
                images.add("https://i.pinimg.com/236x/8d/de/9f/8dde9f4c67a762b5a71c85473f93c302.jpg");
                images.add("https://i.pinimg.com/236x/ad/8c/37/ad8c377319ac2e82ac19e737e0be1333.jpg");
                images.add("https://i.pinimg.com/236x/88/6d/6f/886d6f1a4e86d6b71f0c718c119e31fd.jpg");
                images.add("https://i.pinimg.com/236x/43/00/63/4300635a19e4a9706fdf6cad0b4bcf0e.jpg");
                images.add("https://i.pinimg.com/236x/98/ce/23/98ce23a9ce36bf9d77e0dbdd78346c09.jpg");
                images.add("https://i.pinimg.com/236x/9c/56/ac/9c56ac0cb319a5e0244aedeb5cfa11b1.jpg");
                images.add("https://i.pinimg.com/236x/17/76/37/177637282b5b3bd7c767a871954692ee.jpg");
                images.add("https://i.pinimg.com/236x/fc/3e/98/fc3e98134676d0884a568af953cdbb4a.jpg");
                images.add("https://i.pinimg.com/236x/07/8c/77/078c77939221484cd4ea16463f9e923e.jpg");
                images.add("https://i.pinimg.com/236x/bf/3c/0a/bf3c0ade03b2069bd212cb8f20f60264.jpg");
                images.add("https://i.pinimg.com/236x/b2/b1/d8/b2b1d8a78f4aeeb8ed2bbc228ff48062.jpg");
                images.add("https://i.pinimg.com/236x/ea/cc/f3/eaccf311327901627566b3d9530f2ff1.jpg");
                images.add("https://i.pinimg.com/236x/09/a0/ce/09a0ce629d6f27e9a458f416d281fabb.jpg");
                images.add("https://i.pinimg.com/236x/ce/22/c8/ce22c850ddd82814aa7182f728ed8aab.jpg");
                images.add("https://i.pinimg.com/236x/97/00/ba/9700baafc82e27cb56e8d05b4d4036b2.jpg");
                images.add("https://i.pinimg.com/236x/20/83/2d/20832de16a268d9b8c58457a7bde2571.jpg");
                images.add("https://i.pinimg.com/236x/64/d5/a8/64d5a8535bc00a836331817019cb1561.jpg");
                images.add("https://i.pinimg.com/236x/f0/02/53/f00253afaf63f40b975465729df7c723.jpg");
                images.add("https://i.pinimg.com/236x/f8/07/b5/f807b5463fee558aa5d6663df759ba82.jpg");
                images.add("https://i.pinimg.com/236x/3a/53/79/3a53794269a7ceeb58d84d1e82c0aa6b.jpg");
                break;
            }

            case 4: {

                //DarkMood
                images.add("https://i.pinimg.com/236x/84/9e/43/849e43d68b1e381056da94adcdaa5ebd.jpg");
                images.add("https://i.pinimg.com/236x/52/cd/ed/52cdedecfa5b02791b72ff77c4074536.jpg");
                images.add("https://i.pinimg.com/236x/10/c6/ca/10c6ca51d701f5788ea7173f014468c9.jpg");
                images.add("https://i.pinimg.com/236x/0b/21/e8/0b21e847b0d26d2cbdacdb98b5963592.jpg");
                images.add("https://i.pinimg.com/236x/d8/bb/65/d8bb652e166b2ef77f79413eb6c852e1.jpg");
                images.add("https://i.pinimg.com/236x/79/c1/10/79c110cad590fc5b1bf3af0a00651186.jpg");
                images.add("https://i.pinimg.com/236x/51/1f/71/511f71d4a21fff990c32ea520ec11b6f.jpg");
                images.add("https://i.pinimg.com/236x/3d/1c/a8/3d1ca88079e21a155937b0fd49e0a0bd.jpg");
                images.add("https://i.pinimg.com/750x/29/db/dd/29dbdd2c6254870d23f144e19caeb692.jpg");
                images.add("https://i.pinimg.com/750x/0e/f0/04/0ef004fd24d5505532c4bfc3af1d07fa.jpg");
                images.add("https://i.pinimg.com/750x/54/12/63/541263244e8ea97cf917245677f423b1.jpg");
                images.add("https://i.pinimg.com/750x/0b/3d/97/0b3d9787fb1bcf28ac0ac7b151e78d18.jpg");
                images.add("https://i.pinimg.com/564x/15/04/ec/1504ec579a5150870184b783b542753a.jpg");
                images.add("https://i.pinimg.com/236x/34/11/ad/3411adc109039bfb3a5ca3e73fbe1ac1.jpg");
                images.add("https://i.pinimg.com/236x/4e/b6/bc/4eb6bceda12038725de2c2e9b3c375ed.jpg");
                images.add("https://i.pinimg.com/236x/73/01/80/7301800a3fe0ced9818e931eec8aa25a.jpg");
                images.add("https://i.pinimg.com/236x/46/1c/3f/461c3fbb2ae293543d105feb2009d9dc.jpg");
                images.add("https://i.pinimg.com/236x/95/8e/ff/958eff9e39c308d79b2286616098a1f4.jpg");
                images.add("https://i.pinimg.com/236x/b5/35/32/b53532def0143838ad6243908ee94253.jpg");
                images.add("https://i.pinimg.com/236x/1e/8b/f8/1e8bf890db711ce1a1f773d9cbd513d0.jpg");
                images.add("https://i.pinimg.com/236x/a7/5a/08/a75a080b3394516cab7fd68ea4ffe6fa.jpg");
                images.add("https://i.pinimg.com/236x/2f/02/24/2f0224ca644ca9f44a1e83b0c9aca639.jpg");
                images.add("https://i.pinimg.com/236x/a6/30/d2/a630d253e2c211078209cff842a3ae57.jpg ");
                images.add("https://i.pinimg.com/236x/f5/61/a6/f561a6616897694a957e58aa2375e605.jpg");
                images.add("https://i.pinimg.com/236x/aa/0d/3e/aa0d3e75a47e1e9b12cbfe7851c88eaf.jpg");
                images.add("https://i.pinimg.com/236x/6d/77/24/6d7724f2b2e6764c23214a465ac70689.jpg");
                images.add("https://i.pinimg.com/236x/68/db/cc/68dbcc3a1887ce1d9f32aa31d1f6c620.jpg");
                images.add("https://i.pinimg.com/236x/0d/91/73/0d9173d7457a5fb19bff4c1a1ce82187.jpg ");
                images.add("https://i.pinimg.com/236x/09/27/d1/0927d10206a13c2dfa1ca0db29e58359.jpg");
                images.add("https://i.pinimg.com/236x/4e/5a/2c/4e5a2c30b39a225588c85c2bd17b9f48.jpg");
                images.add("https://i.pinimg.com/236x/a7/59/f5/a759f563d553531a35966d83a495a462.jpg");
                images.add("https://i.pinimg.com/236x/c8/a5/b0/c8a5b0c9e29257c760a1ad782af58d77.jpg");
                break;
            }

            case 5: {

                //Marvel
                images.add("https://i.pinimg.com/564x/36/dc/73/36dc73903f9b002e9191600dfb49d4e0.jpg");
                images.add("https://i.pinimg.com/564x/b6/44/87/b6448790a2217b79113f92711ef15ca0.jpg");
                images.add("https://i.pinimg.com/564x/81/0c/6e/810c6efb928f3a51829ba5f7b37d7857.jpg");
                images.add("https://i.pinimg.com/236x/25/d6/ff/25d6ffe8bc0cb42db020f99672f3b151.jpg");
                images.add("https://i.pinimg.com/236x/fc/84/e5/fc84e50b21d135452709d326a9fe9c6f.jpg");
                images.add("https://i.pinimg.com/236x/b4/c1/1a/b4c11a320b8edcc8292b75ceea6e871c.jpg");
                images.add("https://i.pinimg.com/236x/cf/93/1d/cf931dc3288df0ef00ed25fe8f310faf.jpg");
                images.add("https://i.pinimg.com/236x/69/90/da/6990da2937ea0778d58bf09a39652570.jpg");
                images.add("https://i.pinimg.com/564x/c9/57/12/c95712d6a36cc42cd7085fae5aa45ce5.jpg");
                images.add("https://i.pinimg.com/236x/ee/a5/53/eea553f5c6c56ba349d8c0e7d11e57b4.jpg");
                images.add("https://i.pinimg.com/236x/9f/66/70/9f6670c65926982258155e8004db4f78.jpg");
                images.add("https://i.pinimg.com/236x/10/b3/d2/10b3d235e3cbd4e58c671f7a960c3f5c.jpg");
                images.add("https://i.pinimg.com/236x/c5/a7/d1/c5a7d1deb61593619303bb170e67e7f8.jpg");
                images.add("https://i.pinimg.com/236x/68/ad/d2/68add299e88bd94f9fa63c89c671da5c.jpg");
                images.add("https://i.pinimg.com/236x/29/24/0d/29240df01c0897e1e352f4545c7b5049.jpg");
                images.add("https://i.pinimg.com/236x/fd/cd/d6/fdcdd6002d34ff687fb9121fdd7e6a37.jpg");
                images.add("https://i.pinimg.com/236x/c4/ff/6a/c4ff6a71a01d592b4c3234c0709dfbae.jpg");
                images.add("https://i.pinimg.com/236x/c8/09/53/c80953c20cdf49e7caf573e9f0435ef4.jpg");
                images.add("https://i.pinimg.com/236x/2d/53/c6/2d53c602cf4a021ed703cad54506d03a.jpg");
                images.add("https://i.pinimg.com/236x/68/b8/dc/68b8dcda2e37e71d3905d0f216e8d9a4.jpg");
                images.add("https://i.pinimg.com/236x/90/d5/6e/90d56e68d34a445a9841f7aa96fc9197.jpg");
                images.add("https://i.pinimg.com/564x/3b/aa/6c/3baa6c9695961993951c3e909f4ade8a.jpg");
                images.add("https://i.pinimg.com/236x/6e/33/dc/6e33dcd07d1f674092a97fbabfa0832f.jpg");
                images.add("https://i.pinimg.com/236x/72/47/fd/7247fd9bce7a46fb67a8f8449293e0ce.jpg");
                images.add("https://i.pinimg.com/236x/e8/b6/0e/e8b60ed081ded90f284aa7c6c3ef3ced.jpg");
                images.add("https://i.pinimg.com/236x/3f/0a/a8/3f0aa8bec7e7b87f45be4bf28ccc2823.jpg");
                images.add("https://i.pinimg.com/236x/82/6c/ae/826caef9bee3a05027c7b0bd8f4b20bc.jpg");
                images.add("https://i.pinimg.com/236x/46/5b/3b/465b3b9bc05e8bda0904d35552a8a7ad.jpg");
                images.add("https://i.pinimg.com/236x/fc/e9/6a/fce96a3cc3bacbbb537ac56ce110717c.jpg");
                images.add("https://i.pinimg.com/236x/6d/5a/06/6d5a06c5a39c1770741a7064cd1bbd81.jpg");
                images.add("https://i.pinimg.com/236x/07/d7/2d/07d72dc242d82b6c55063fb610f12c17.jpg");
                images.add("https://i.pinimg.com/236x/46/a1/65/46a1654e09981467473fab56bad2e1d4.jpg");
                images.add("https://i.pinimg.com/236x/16/78/ef/1678ef738af0332ecaa72afa384029e0.jpg");
                images.add("https://i.pinimg.com/236x/a7/3a/f0/a73af0041943ba3bfd9a7496d68750c2.jpg");
                images.add("https://i.pinimg.com/236x/aa/f3/7b/aaf37bc7484c8d8d8e6d4723a0663819.jpg");
                images.add("https://i.pinimg.com/236x/99/57/78/995778f502ef5cc4a45b50fc427522cd.jpg");
                images.add("https://i.pinimg.com/564x/a7/31/0c/a7310cedd4c3aed66b6d461df64b875b.jpg");
                images.add("https://i.pinimg.com/236x/ef/f6/d7/eff6d787587ab80a4fae829cd688f8f2.jpg");
                images.add("https://i.pinimg.com/236x/aa/08/12/aa08120bcb1376364c42d88477108674.jpg");
                images.add("https://i.pinimg.com/236x/d6/fb/55/d6fb55faa7775ab8379b8235dfe4aea8.jpg");
                images.add("https://i.pinimg.com/236x/ff/15/10/ff15100dce4f00df133823605b42f6ea.jpg");
                images.add("https://i.pinimg.com/236x/61/15/e6/6115e6fd71b18404c76ca2f0c8ff1ad8.jpg");
                images.add("https://i.pinimg.com/236x/93/0f/88/930f8881410247e497182f7e8f224f4a.jpg");
                images.add("https://i.pinimg.com/236x/62/9f/84/629f84844c538f3b6b67c0ec4f1ac2bd.jpg");
                images.add("https://i.pinimg.com/236x/db/f1/2b/dbf12bcccb4bafbe1577022ae58e5c3f.jpg");
                images.add("https://i.pinimg.com/236x/5c/38/3f/5c383f5aeec5188134cb9cca74a9db1c.jpg");
                images.add("https://i.pinimg.com/236x/e5/ea/5e/e5ea5e470450bc809f88e345ea3cf9be.jpg");
                images.add("https://i.pinimg.com/236x/9f/1a/02/9f1a02265a5ff0cd8c04044c0791c2c4.jpg");
                images.add("https://i.pinimg.com/236x/cd/9e/f3/cd9ef33271aeb214154d594598ce9c0b.jpg");
                images.add("https://i.pinimg.com/236x/d6/cc/11/d6cc112aa0457c0629d077fd5b76ca18.jpg");
                images.add("https://i.pinimg.com/236x/c3/4c/cd/c34ccdaa6d7c3aed2e2f099e1668a032.jpg");
                images.add("https://i.pinimg.com/564x/d8/b6/02/d8b6024c4a47b61ac205a12650e6f49f.jpg");
                images.add("https://i.pinimg.com/236x/f6/5b/e5/f65be56f74c41e1e16fd00fc2c403421.jpg");
                images.add("https://i.pinimg.com/236x/c7/98/27/c7982749c89170687a699f39bfff8916.jpg");
                images.add("https://i.pinimg.com/236x/90/f6/74/90f674c4149f0c4ad1631f244736402c.jpg");
                images.add("https://i.pinimg.com/236x/f0/14/1d/f0141de92f03630fb1234e3c145f5773.jpg ");
                images.add("https://i.pinimg.com/236x/ed/66/d3/ed66d378f30a941efe3649dedc85e2c6.jpg");
                images.add("https://i.pinimg.com/236x/65/32/43/65324331ea8c7c1d63294ae3cc885018.jpg");
                images.add("https://i.pinimg.com/236x/ff/a5/f5/ffa5f5ba05210447ba98e019d0bc9384.jpg");
                images.add("https://i.pinimg.com/236x/e9/39/43/e939430085df9434ad0dfa1c92d0b58e.jpg");
                images.add("https://i.pinimg.com/236x/ca/7f/f7/ca7ff79d2057c576ee30392a39110837.jpg");
                images.add("https://i.pinimg.com/236x/82/18/0e/82180eedaed4e64d03b46a57b35a9a86.jpg");
                images.add("https://i.pinimg.com/236x/d0/7e/bb/d07ebb9641a31a6de894b5c8e0f5390c.jpg");
                images.add("https://i.pinimg.com/236x/03/14/af/0314afa36952de4840a76e35a380e4b7.jpg");
                images.add("https://i.pinimg.com/236x/e8/57/48/e857480251e9cc20bdc292c58ad8a248.jpg");
                images.add("https://i.pinimg.com/236x/ab/c2/5f/abc25fab29eacb30d0eeca71c37b4d70.jpg");
                images.add("https://i.pinimg.com/236x/d4/10/34/d410344aa2427100cb4a3cb5df7497a7.jpg");
                images.add("https://i.pinimg.com/236x/fa/65/f3/fa65f3e81f1e89d79d8ad7b291d2b6b8.jpg");
                images.add("https://i.pinimg.com/236x/47/67/4e/47674ea61093d14aed6579932557e771.jpg");
                images.add("https://i.pinimg.com/236x/3f/bc/51/3fbc515791329a0eca81e0c7ceb8888b.jpg");
                images.add("https://i.pinimg.com/236x/cb/3f/a2/cb3fa2b9ce3ae8506373df23d53e7c85.jpg");
                images.add("https://i.pinimg.com/236x/4d/31/c4/4d31c4e9df2d0dc8dfa3224e05a7b4da.jpg");
                images.add("https://i.pinimg.com/236x/10/08/71/100871ff13ddfb7ee750f0d6aaeab46e.jpg");
                images.add("https://i.pinimg.com/236x/60/f6/09/60f6095037d8163f05028ca83e5bca34.jpg");
                images.add("https://i.pinimg.com/236x/ef/4b/c0/ef4bc0a58f0142bee4c331ba02db1acf.jpg");
                images.add("https://i.pinimg.com/236x/7f/67/12/7f6712632440713e375da2ffe48043d9.jpg");
                images.add("https://i.pinimg.com/236x/65/59/39/6559394d1fcff59e9a4c570c90837e6c.jpg");
                images.add("https://i.pinimg.com/236x/cd/05/e3/cd05e3e9f6c9afe445da7eaaf1156576.jpg");
                images.add("https://i.pinimg.com/236x/26/e2/de/26e2de2af1507448b03d1e1d73a58613.jpg");
                images.add("https://i.pinimg.com/236x/91/fa/de/91fade2449875070b84b9b1008e1b5d1.jpg");
                images.add("https://i.pinimg.com/236x/50/27/65/50276537c771e366e324e699e74cf07c.jpg");
                images.add("https://i.pinimg.com/236x/a2/7e/6a/a27e6afa4306326855f8c4e661141d8f.jpg");
                images.add("https://i.pinimg.com/236x/c7/11/38/c7113872dc0143ad365d172bb62b0b7d.jpg");
                images.add("https://i.pinimg.com/236x/54/11/db/5411dbad0e63698d9ae84db2626caa95.jpg");
                break;
            }

            case 6: {

                //Galaxy
                images.add("https://i.pinimg.com/236x/ca/6f/cd/ca6fcd4c973692b159b1c113532a9dac.jpg");
                images.add("https://i.pinimg.com/236x/20/a0/d9/20a0d9e93d35d4a32cadc7d6f2ad1618.jpg");
                images.add("https://i.pinimg.com/236x/5e/68/5f/5e685f39407f71c6d96e7cca0b2f2f7b.jpg");
                images.add("https://i.pinimg.com/236x/1e/a8/b6/1ea8b6b99997858595d0e3869f289701.jpg");
                images.add("https://i.pinimg.com/236x/11/20/fa/1120fa85650eaceca17131b2a07751b7.jpg");
                images.add("https://i.pinimg.com/236x/80/89/e8/8089e883f57338268172cf625583cc60.jpg");
                images.add("https://i.pinimg.com/236x/c4/77/46/c477469d5bd5f1797cd74bb65847f7db.jpg ");
                images.add("https://i.pinimg.com/564x/df/39/6e/df396eb36ac4d419a997e55898aa8c8f.jpg");
                images.add("https://i.pinimg.com/236x/d9/9c/87/d99c876721d902ef5f6d9ae17e1d5de0.jpg");
                images.add("https://i.pinimg.com/564x/31/d4/ca/31d4caab6fa0e5c6dd69dee132ca9e05.jpg");
                images.add("https://i.pinimg.com/236x/d5/2d/ca/d52dca8265170c32714a41fb011ac14c.jpg");
                images.add("https://i.pinimg.com/236x/de/a9/b9/dea9b95d09ff4e65bc96413617fb9740.jpg");
                images.add("https://i.pinimg.com/236x/9a/85/8d/9a858d0fdc678b8d87f56eb3e4c3a419.jpg");
                images.add("https://i.pinimg.com/236x/03/f3/a5/03f3a5c95a961704e8b18c9a1dcd3d63.jpg");
                images.add("https://i.pinimg.com/236x/75/52/51/75525162388b6610a07db57f45305238.jpg");
                images.add("https://i.pinimg.com/236x/d0/91/b2/d091b2c523a8845ce6db8bbbfb5c1d1e.jpg");
                images.add("https://i.pinimg.com/236x/62/7e/37/627e37fe3a2ed77bbc238da12065cbdd.jpg");
                images.add("https://i.pinimg.com/236x/2c/a1/9e/2ca19e159403a79c8be7feca6248894a.jpg");
                images.add("https://i.pinimg.com/236x/91/51/75/9151754a1f89f33ca83d49b127f48f99.jpg");
                images.add("https://i.pinimg.com/236x/f2/7c/5b/f27c5bc822b6b59b01076002baa4e1ab.jpg");
                images.add("https://i.pinimg.com/236x/13/0d/c4/130dc4d30d423d1e8087bba9ce2f24fa.jpg");
                images.add("https://i.pinimg.com/236x/97/f8/12/97f8125a869056c0c5ab9f07c8050454.jpg");
                images.add("https://i.pinimg.com/236x/3c/ba/bb/3cbabb482d2d6221d16975e9263a1fd4.jpg");
                images.add("https://i.pinimg.com/236x/6b/78/d2/6b78d2996c65b4a29623b396a0f1e0fd.jpg");
                images.add("https://i.pinimg.com/236x/cb/96/b4/cb96b4e07bac455a06508fabc9434d1d.jpg");
                images.add("https://i.pinimg.com/236x/e6/06/4f/e6064f3f3747804d1173559041afde7a.jpg");
                images.add("https://i.pinimg.com/236x/49/a3/10/49a3100bb1181d8c2cf2983d7bb946b4.jpg");
                images.add("https://i.pinimg.com/236x/2a/3f/be/2a3fbe141b5f1462a6d9837f7f21fa25.jpg");
                images.add("https://i.pinimg.com/236x/2a/3f/be/2a3fbe141b5f1462a6d9837f7f21fa25.jpg");
                images.add("https://i.pinimg.com/236x/98/26/0e/98260e0ae50b4ae68a900906f41cec87.jpg");
                break;
            }

            case 7: {

                //Cars
                images.add("https://i.pinimg.com/236x/0c/bd/c9/0cbdc992ba95501c9eb32b6f6c07ee85.jpg");
                images.add("https://i.pinimg.com/236x/fe/b0/ef/feb0ef55f716a4c2e72739bdcb74b596.jpg");
                images.add("https://i.pinimg.com/236x/04/c4/44/04c44441e0ec0ad43a2f56e61e77988d.jpg ");
                images.add("https://i.pinimg.com/236x/36/85/b2/3685b2068e39b706082770223b62c0bb.jpg");
                images.add("https://i.pinimg.com/236x/14/13/8c/14138caea4e4be5422071bdfa2f688cf.jpg");
                images.add("https://i.pinimg.com/236x/c4/77/7e/c4777e7b8eb367eecf171ad4598075b7.jpg");
                images.add("https://i.pinimg.com/236x/8c/46/42/8c46424a794d901e1f655090e9db83f2.jpg");
                images.add("https://i.pinimg.com/236x/a8/b1/e5/a8b1e57b4cbbf6500607bdef84366439.jpg");
                images.add("https://i.pinimg.com/236x/bb/87/58/bb87587a3e472c4f9aae458971bbb58c.jpg");
                images.add("https://i.pinimg.com/236x/8d/06/ab/8d06abcdfb73023a85f0d373151f6ca3.jpg");
                images.add("https://i.pinimg.com/236x/4b/3c/4c/4b3c4c6f0a49261ef919321a094754db.jpg");
                images.add("https://i.pinimg.com/236x/4b/f4/d3/4bf4d3f5bce886138ca5906e40587d5f.jpg");
                images.add("https://i.pinimg.com/236x/60/ad/c0/60adc041892779a6a204292c6fe16b17.jpg");
                images.add("https://i.pinimg.com/236x/1e/bc/c4/1ebcc4a5d8f8fb1dfd25d64ff902d3c9.jpg");
                images.add("https://i.pinimg.com/564x/e9/33/c9/e933c98ac5af117c251c564ad7714dd0.jpg");
                images.add("https://i.pinimg.com/236x/4b/48/b8/4b48b8523d6d9aa44f54830f5d3994e5.jpg");
                images.add("https://i.pinimg.com/236x/3d/e5/4b/3de54b53d04cb11a8bbfbb3ba38c6536.jpg");
                images.add("https://i.pinimg.com/236x/cd/21/73/cd217369b5ab2d4db7d879b3bf009540.jpg");
                images.add("https://i.pinimg.com/236x/1e/e8/9d/1ee89d361338587adfd1e5e1ad8fd4a8.jpg");
                images.add("https://i.pinimg.com/236x/a8/08/03/a80803d88c36b9bc1b8b50120553d442.jpg");
                images.add("https://i.pinimg.com/236x/fe/e2/cb/fee2cb55c37bc6a2b090ff1ae83f42a8.jpg");
                images.add("https://i.pinimg.com/236x/31/85/cb/3185cbf676bad99e82decee6110c3d52.jpg");
                images.add("https://i.pinimg.com/236x/47/96/50/479650714b0febe1278929026d7bf87b.jpg");
                images.add("https://i.pinimg.com/236x/fc/3d/0c/fc3d0ce2ff0844f40b23b3016df8494e.jpg");
                images.add("https://i.pinimg.com/236x/2f/c0/70/2fc0707d7e0fb30925fc5d1e8071634a.jpg");
                images.add("https://i.pinimg.com/236x/61/74/77/6174770a343a0d4cd4abc0dbf4493ba4.jpg");
                images.add("https://i.pinimg.com/236x/e9/66/20/e966207e1d0924b82bb7a986239699f7.jpg");
                images.add("https://i.pinimg.com/236x/54/cd/76/54cd764369c4b3d4e7a8bf0a4cdc0bdc.jpg");
                images.add("https://i.pinimg.com/236x/8d/25/42/8d25423fccc2d3694cf9fc73a5e1fa1d.jpg");
                images.add("https://i.pinimg.com/236x/22/53/be/2253be3cb27fffaef4137394e1288387.jpg");
                images.add("https://i.pinimg.com/236x/96/33/36/963336075a39468bc6925cdd353b687b.jpg");
                images.add("https://i.pinimg.com/236x/61/aa/43/61aa436e793114a1c60375d5fd102108.jpg");
                images.add("https://i.pinimg.com/236x/58/9c/76/589c76ca866a85982f9065966e7ddf09.jpg");
                images.add("https://i.pinimg.com/236x/c0/7d/fb/c07dfbe395faa4082ea2216b707c92c1.jpg");
                images.add("https://i.pinimg.com/236x/bf/1a/2e/bf1a2e7612957c7cf09b0dc8802814fb.jpg");
                images.add("https://i.pinimg.com/236x/ca/30/1c/ca301c9a2e179c3012ad99cf7fa640bc.jpg");
                images.add("https://i.pinimg.com/564x/d3/c2/e0/d3c2e0a7415bd9e88b8b3317553ebb30.jpg");
                images.add("https://i.pinimg.com/236x/30/42/d9/3042d9f4eefd72293c028dd247fc5b34.jpg");
                images.add("https://i.pinimg.com/236x/a2/f2/d0/a2f2d059a1571687576c76e8b578bc90.jpg ");
                images.add("https://i.pinimg.com/236x/07/3f/c3/073fc35df088619e4fcc8a333fb51758.jpg");
                images.add("https://i.pinimg.com/564x/6f/ea/16/6fea16c704aea11325491903917e2256.jpg");
                images.add("https://i.pinimg.com/236x/89/5d/68/895d68c6fafabb1284fbe5dcf684cca8.jpg");
                images.add("https://i.pinimg.com/236x/6c/f2/00/6cf2005db9528dcfb215d397c09b607f.jpg");
                images.add("https://i.pinimg.com/236x/34/69/01/346901c637555baf135428b6b7de8bbf.jpg");
                images.add("https://i.pinimg.com/236x/73/d8/a9/73d8a97989cf28a46f9a12bddfabd94b.jpg");
                images.add("https://i.pinimg.com/236x/ee/d4/36/eed4363fff855d219ddbd4d100c8c163.jpg");
                images.add("https://i.pinimg.com/236x/ce/20/48/ce2048a4359a4854c841321aad6dbe90.jpg");
                images.add("https://i.pinimg.com/236x/1a/a5/66/1aa566bdaa25225adf6d0f1bbe824923.jpg");
                images.add("https://i.pinimg.com/236x/d6/f5/25/d6f525294b69e346d097be2dd8238728.jpg");
                images.add("https://i.pinimg.com/236x/f2/91/c2/f291c2ab2c5bfc3256fef7c4ef81cf06.jpg");
                images.add("https://i.pinimg.com/236x/1f/d9/1b/1fd91bd30c507e12ee23ae2d47777d14.jpg");
                images.add("https://i.pinimg.com/236x/db/e6/a5/dbe6a508930bc9a791b19fd8cb118bf2.jpg");
                images.add("https://i.pinimg.com/236x/4e/ee/de/4eeede9212dfb94451ea9f2e7ca4f632.jpg");
                images.add("https://i.pinimg.com/236x/d2/c9/fa/d2c9fa977add455069414bce44676fad.jpg");
                images.add("https://i.pinimg.com/236x/34/34/13/343413739d701c495a7c409e5a3f1d8c.jpg");
                images.add("https://i.pinimg.com/236x/ea/ae/aa/eaaeaadc51f6a03b7aa9a0164883acea.jpg");
                images.add("https://i.pinimg.com/236x/e1/20/a8/e120a8628766f705cfd017ecf9ef00ea.jpg");
                break;
            }

            default:
                break;

        }

    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetwork() != null && cm.getActiveNetworkInfo().isConnected();
    }
}