package com.jannahsoftware.moviedb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jannahsoftware.Adapters.MovieAdapter;
import com.jannahsoftware.Adapters.PopularTVAdapter;
import com.jannahsoftware.Model.Movie;
import com.jannahsoftware.Model.TVSeries;
import com.jannahsoftware.json.TVSeriesDBJSON;

import java.util.ArrayList;
import java.util.List;

public class PopularTVShows extends AppCompatActivity
{
    TVSeriesDBJSON tvSeriesDBJSON = new TVSeriesDBJSON();

    //adapter vars
    private static RecyclerView recyclerView;
    public static RecyclerView.Adapter adapter;
    public static List<TVSeries> tvSeriesList;
    private static LinearLayoutManager linearLayoutManager;
    private SnapHelper snapHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Popular TV Shows");
        setContentView(R.layout.activity_popular_tvshows);

        tvSeriesDBJSON.GetAllPopularTVSeries();

        SetRecyclerVars();
        BottomNav();
    }


    private void SetRecyclerVars()
    {
        snapHelper = new PagerSnapHelper();
        recyclerView = findViewById(R.id.pop_tv_rec);
        tvSeriesList = new ArrayList<>();
        adapter = new PopularTVAdapter(tvSeriesList, this);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        linearLayoutManager.getOrientation();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        snapHelper.attachToRecyclerView(recyclerView);
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
                        startActivity(new Intent(PopularTVShows.this, MainActivity.class));
                        break;
                    case R.id.movies:
                        startActivity(new Intent(PopularTVShows.this, MovieOptions.class));
                        break;
                    case R.id.tvseries:
                        startActivity(new Intent(PopularTVShows.this, TVOptions.class));
                        break;
                    case R.id.search:
                        startActivity(new Intent(PopularTVShows.this, SearchTVShows.class));
                        break;
                    case R.id.trend:
                        startActivity(new Intent(PopularTVShows.this, TrendingActivity.class));
                        break;
                    default:
                        //Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }
}
