package com.jannahsoftware.moviedb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jannahsoftware.Adapters.MovieAdapter;
import com.jannahsoftware.Application.App;
import com.jannahsoftware.Constants.Conts;
import com.jannahsoftware.Model.Movie;
import com.jannahsoftware.json.MovieDBJSON;
import com.jannahsoftware.json.TVSeriesDBJSON;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private MovieDBJSON movieDBJSON = new MovieDBJSON();
    private TVSeriesDBJSON tvSeriesDBJSON = new TVSeriesDBJSON();
    public static String myKey;


    //adapter vars
    private static RecyclerView recyclerView;
    public static RecyclerView.Adapter adapter;
    public static List<Movie> movieList;
    private static LinearLayoutManager linearLayoutManager;
    private SnapHelper snapHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SetRecyclerVars();
        BottomNav();

        myKey = getResources().getString(R.string.apikey);
        Log.d("APIKEY", "onCreate: " + App.key);
        Conts.requestQueue = Volley.newRequestQueue(this);

        movieDBJSON.GetAllPopularMovies();
        //movieDBJSON.GetUpcomingMovies();
        //movieDBJSON.GetTopRatedMovies();
        //movieDBJSON.GetNowPlayingMovies();
        //movieDBJSON.GetLatestMovies();
        //movieDBJSON.SearchMovies();


        //tvSeriesDBJSON.GetAllPopularTVSeries();
        //tvSeriesDBJSON.GetNowPlayingTVSeries();
        //tvSeriesDBJSON.GetAiringTodayTVSeries();
        //tvSeriesDBJSON.GetTopRatedTVSeries();
        //tvSeriesDBJSON.GetLatestTVSeries();
        //tvSeriesDBJSON.SearchTVSeries();

    }

    private void SetRecyclerVars()
    {
        snapHelper = new PagerSnapHelper();
        recyclerView = findViewById(R.id.pop_movies_rec);
        movieList = new ArrayList<>();
        adapter = new MovieAdapter(movieList, this);

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
                        startActivity(new Intent(MainActivity.this, MainActivity.class));
                        break;
                    case R.id.movies:
                        break;
                    case R.id.tvseries:
                        break;
                }


                return false;
            }
        });
    }
}


































