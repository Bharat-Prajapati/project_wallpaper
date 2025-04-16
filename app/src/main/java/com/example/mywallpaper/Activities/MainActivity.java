package com.example.mywallpaper.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mywallpaper.CuratedAdapter;
import com.example.mywallpaper.Interfaces.CuratedWallpaperListener;
import com.example.mywallpaper.Interfaces.SearchWallpaperListener;
import com.example.mywallpaper.Interfaces.onRecyclerClickListener;
import com.example.mywallpaper.Models.CuretedApiResponse;
import com.example.mywallpaper.Models.Photo;
import com.example.mywallpaper.Models.SearchApiResponse;
import com.example.mywallpaper.R;
import com.example.mywallpaper.WallpaperRepository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;

public class MainActivity extends AppCompatActivity implements onRecyclerClickListener {

    Toolbar toolbar;
    RecyclerView homeRecyclerView;
    CuratedAdapter adapter;
    WallpaperRepository wallpaperRepository;
    ProgressDialog progressDialog;
    FloatingActionButton next_btn, previous_btn;
    long page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializeView();

        progressDialog.setTitle("Loading...");

        setSupportActionBar(toolbar);

        wallpaperRepository.getCuratedWallpapers(listener, "1", "20");

        next_btn.setOnClickListener(v -> {
            progressDialog.show();
            String next_page = String.valueOf(page+1);
            wallpaperRepository.getCuratedWallpapers(listener, next_page, "20");
        });


        previous_btn.setOnClickListener(v -> {
            if (page > 1) {
                progressDialog.show();
                String prev_page = String.valueOf(page - 1);
                wallpaperRepository.getCuratedWallpapers(listener, prev_page, "20");
            }
        });

    }

    private final CuratedWallpaperListener listener = new CuratedWallpaperListener() {
        @Override
        public void onSuccess(CuretedApiResponse response, String message) {
            progressDialog.show();
            if (response != null) {
                page = response.getPage();
                showPhoto(response.getPhotos());
            }
            else {
                Toast.makeText(MainActivity.this, "photo is empty", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(String message) {
            progressDialog.dismiss();
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private void showPhoto(List<Photo> photos) {
        progressDialog.dismiss();
        homeRecyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        adapter = new CuratedAdapter(getApplicationContext(), photos, this);
        homeRecyclerView.setAdapter(adapter);
    }

    private void initializeView() {
        progressDialog = new ProgressDialog(MainActivity.this);
        toolbar = findViewById(R.id.homeToolbar);
        homeRecyclerView = findViewById(R.id.rv_home_list);
        wallpaperRepository = new WallpaperRepository(getApplicationContext());
        next_btn = findViewById(R.id.btn_next);
        previous_btn = findViewById(R.id.btn_previous);
    }

    @Override
    public void onClick(Photo photo) {
        Intent wallpaperIntent = new Intent(MainActivity.this, WallpaperActivity.class);
        wallpaperIntent.putExtra("photo", photo);
        startActivity(wallpaperIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        if (menuItem != null) {
            SearchView searchView = (SearchView) menuItem.getActionView();
            if (searchView != null) {
                searchView.setQueryHint("Type here to search...");
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        progressDialog.show();
                        wallpaperRepository.getSearchWallpapers(searchListener, "1", "20", query);
                        return true;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        return false;
                    }
                });
            }
        }
        return super.onCreateOptionsMenu(menu);
    }

    private final SearchWallpaperListener searchListener = new SearchWallpaperListener() {
        @Override
        public void onSuccess(SearchApiResponse response, String message) {
            progressDialog.show();
            if (!response.getPhotos().isEmpty()){
                page = response.getPage();
                showPhoto(response.getPhotos());
            }
            else {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Photo is not available", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(String message) {
            progressDialog.dismiss();
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };
}