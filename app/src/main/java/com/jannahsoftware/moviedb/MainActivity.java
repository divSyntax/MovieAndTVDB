package com.jannahsoftware.moviedb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jannahsoftware.Adapters.MovieAdapter;
import com.jannahsoftware.Application.App;
import com.jannahsoftware.Constants.Conts;
import com.jannahsoftware.Model.Movie;
import com.jannahsoftware.Model.Trending;
import com.jannahsoftware.NetWork.BroadCastReciever;
import com.jannahsoftware.json.MovieDBJSON;
import com.jannahsoftware.json.TVSeriesDBJSON;
import com.jannahsoftware.json.TrendingDBJSON;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    TVSeriesDBJSON tvSeriesDBJSON = new TVSeriesDBJSON();
    private MovieDBJSON movieDBJSON = new MovieDBJSON();
    public static String myKey;
    private BroadCastReciever broadCastReciever;
    public static ProgressBar progressBar;

    private AdView AdView;

    //adapter vars
    private static RecyclerView recyclerView;
    public static RecyclerView.Adapter adapter;
    public static List<Movie> movieList;
    private static LinearLayoutManager linearLayoutManager;
    private SnapHelper snapHelper;
    AdRequest adRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Popular Movies");

        MobileAds.initialize(this);

        adRequest = new AdRequest.Builder().build();
        AdView = findViewById(R.id.adView);

        loadAD();
        BroadCastIntent();
        SetRecyclerVars();
        BottomNav();

        myKey = getResources().getString(R.string.apikey);
        Conts.requestQueue = Volley.newRequestQueue(this);
        progressBar = findViewById(R.id.bar);



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
        tvSeriesDBJSON.GetLatestTVSeries();
        //tvSeriesDBJSON.SearchTVSeries();

//        TrendingDBJSON trendingDBJSON = new TrendingDBJSON();
//        trendingDBJSON.getTrending();


    }

    private void BroadCastIntent()
    {
        broadCastReciever = new BroadCastReciever();
        registerReceiver(broadCastReciever, new IntentFilter(ConnectivityManager.EXTRA_NO_CONNECTIVITY));
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
                        startActivity(new Intent(MainActivity.this, MovieOptions.class));
                        break;
                    case R.id.tvseries:
                        startActivity(new Intent(MainActivity.this, TVOptions.class));
                        break;
                    case R.id.search:
                        startActivity(new Intent(MainActivity.this, SearchMovies.class));
                        break;
                    case R.id.trend:
                        startActivity(new Intent(MainActivity.this, TrendingActivity.class));
                        break;
                     default:
                         //Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                         break;
                }
                return false;
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        //unregisterReceiver(broadCastReciever);
    }

    private void loadAD()
    {
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                Log.d("ADS", "onInitializationComplete: " + initializationStatus);
            }
        });

        AdView.loadAd(adRequest);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.game:
                Toast.makeText(this, "Coming soon...", Toast.LENGTH_SHORT).show();
                break;
             default:
                 //
                 break;
        }



        return true;
    }
}


































