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
import com.jannahsoftware.Adapters.PopularTVAdapter;
import com.jannahsoftware.Adapters.TVSeriesAiringTodayAdapter;
import com.jannahsoftware.Model.TVSeries;
import com.jannahsoftware.json.TVSeriesDBJSON;

import java.util.ArrayList;
import java.util.List;

public class TVSeriesAiringToday extends AppCompatActivity
{

    TVSeriesDBJSON tvSeriesDBJSON = new TVSeriesDBJSON();

    //adapter vars
    private static RecyclerView recyclerView;
    public static RecyclerView.Adapter adapter;
    public static List<TVSeries> tvSeriesList;
    private static LinearLayoutManager linearLayoutManager;
    private SnapHelper snapHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvseries_airing_today);

        setTitle("TV Shows Airing Today");

        tvSeriesDBJSON.GetAiringTodayTVSeries();

        SetRecyclerVars();
        BottomNav();
    }

    private void SetRecyclerVars()
    {
        snapHelper = new PagerSnapHelper();
        recyclerView = findViewById(R.id.tvseries_rec);
        tvSeriesList = new ArrayList<>();
        adapter = new TVSeriesAiringTodayAdapter(tvSeriesList, this);

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
                        startActivity(new Intent(TVSeriesAiringToday.this, MainActivity.class));
                        break;
                    case R.id.movies:
                        startActivity(new Intent(TVSeriesAiringToday.this, MovieOptions.class));
                        break;
                    case R.id.tvseries:
                        startActivity(new Intent(TVSeriesAiringToday.this, TVOptions.class));
                        break;
                    case R.id.search:
                        startActivity(new Intent(TVSeriesAiringToday.this, SearchTVShows.class));
                        break;
                    case R.id.trend:
                        startActivity(new Intent(TVSeriesAiringToday.this, TrendingActivity.class));
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
