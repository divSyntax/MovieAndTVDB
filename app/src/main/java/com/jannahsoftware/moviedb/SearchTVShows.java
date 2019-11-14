package com.jannahsoftware.moviedb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SearchTVShows extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_tvshows);

        BottomNav();

        setTitle("Search TV Shows");
    }

    private void BottomNav()
    {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.home:
                        startActivity(new Intent(SearchTVShows.this, MainActivity.class));
                        break;
                    case R.id.movies:
                        startActivity(new Intent(SearchTVShows.this, MovieOptions.class));
                        break;
                    case R.id.tvseries:
                        startActivity(new Intent(SearchTVShows.this, TVOptions.class));
                        break;
                    case R.id.search:
                        startActivity(new Intent(SearchTVShows.this, SearchTVShows.class));
                        break;
                    default:
                        //Toast.makeText(MovieOptions.this, "", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }
}
