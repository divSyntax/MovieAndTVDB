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
import android.widget.ProgressBar;

import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jannahsoftware.Adapters.MovieAdapter;
import com.jannahsoftware.Adapters.TopRatedMovieAdapter;
import com.jannahsoftware.Constants.Conts;
import com.jannahsoftware.Model.Movie;
import com.jannahsoftware.NetWork.BroadCastReciever;
import com.jannahsoftware.json.MovieDBJSON;
import com.jannahsoftware.json.TVSeriesDBJSON;

import java.util.ArrayList;
import java.util.List;

public class TopRatedMovies extends AppCompatActivity {

    private MovieDBJSON movieDBJSON = new MovieDBJSON();
    private TVSeriesDBJSON tvSeriesDBJSON = new TVSeriesDBJSON();
    public static String myKey;
    private BroadCastReciever broadCastReciever;
    public static ProgressBar progressBar;

    private static RecyclerView recyclerView;
    public static RecyclerView.Adapter adapter;
    public static List<Movie> movieList;
    private static LinearLayoutManager linearLayoutManager;
    private SnapHelper snapHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_rated_movies);

        setTitle("Top Rated Movies");

        myKey = getResources().getString(R.string.apikey);
        Conts.requestQueue = Volley.newRequestQueue(this);
        progressBar = findViewById(R.id.bar);

        BottomNav();
        SetRecyclerVars();
        movieDBJSON.GetTopRatedMovies();
    }

    private void SetRecyclerVars()
    {
        snapHelper = new PagerSnapHelper();
        recyclerView = findViewById(R.id.top_rated_rec);
        movieList = new ArrayList<>();
        adapter = new TopRatedMovieAdapter(movieList, this);

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
                        startActivity(new Intent(TopRatedMovies.this, MainActivity.class));
                        break;
                    case R.id.movies:
                        startActivity(new Intent(TopRatedMovies.this, MovieOptions.class));
                        break;
                    case R.id.tvseries:
                        startActivity(new Intent(TopRatedMovies.this, TVOptions.class));
                        break;
                    case R.id.search:
                        startActivity(new Intent(TopRatedMovies.this, SearchMovies.class));
                        break;
                    case R.id.trend:
                        startActivity(new Intent(TopRatedMovies.this, TrendingActivity.class));
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
