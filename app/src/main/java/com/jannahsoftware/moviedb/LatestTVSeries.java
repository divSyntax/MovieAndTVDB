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
import com.jannahsoftware.Adapters.LatestTVSeriesAdapter;
import com.jannahsoftware.Adapters.PopularTVAdapter;
import com.jannahsoftware.Model.TVSeries;
import com.jannahsoftware.json.TVSeriesDBJSON;

import java.util.ArrayList;
import java.util.List;

public class LatestTVSeries extends AppCompatActivity
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
        setContentView(R.layout.activity_latest_tvseries);

        setTitle("Latest TV Shows");

        tvSeriesDBJSON.GetLatestTVSeries();

        SetRecyclerVars();
        BottomNav();
    }

    private void SetRecyclerVars()
    {
        snapHelper = new PagerSnapHelper();
        recyclerView = findViewById(R.id.latest_tv_series_rec);
        tvSeriesList = new ArrayList<>();
        adapter = new LatestTVSeriesAdapter(tvSeriesList, this);

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
                        startActivity(new Intent(LatestTVSeries.this, MainActivity.class));
                        break;
                    case R.id.movies:
                        startActivity(new Intent(LatestTVSeries.this, MovieOptions.class));
                        break;
                    case R.id.tvseries:
                        startActivity(new Intent(LatestTVSeries.this, TVOptions.class));
                        break;
                    case R.id.search:
                        startActivity(new Intent(LatestTVSeries.this, SearchTVShows.class));
                        break;
                    case R.id.trend:
                        startActivity(new Intent(LatestTVSeries.this, TrendingActivity.class));
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
