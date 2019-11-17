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
import com.jannahsoftware.Adapters.TrendingAdapter;
import com.jannahsoftware.Constants.Conts;
import com.jannahsoftware.Model.Trending;
import com.jannahsoftware.NetWork.BroadCastReciever;
import com.jannahsoftware.json.MovieDBJSON;
import com.jannahsoftware.json.TrendingDBJSON;

import java.util.ArrayList;
import java.util.List;

public class TrendingActivity extends AppCompatActivity
{
    TrendingDBJSON  trendingDBJSON = new TrendingDBJSON();
    public static String myKey;
    private BroadCastReciever broadCastReciever;
    public static ProgressBar progressBar;

    //adapter vars
    private static RecyclerView recyclerView;
    public static RecyclerView.Adapter adapter;
    public static List<Trending> trendingList;
    private static LinearLayoutManager linearLayoutManager;
    private SnapHelper snapHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending);

        setTitle("Trending Movies");

        myKey = getResources().getString(R.string.apikey);
        Conts.requestQueue = Volley.newRequestQueue(this);
        progressBar = findViewById(R.id.bar);

        SetRecyclerVars();
        BottomNav();

        trendingDBJSON.getTrending();
    }


    private void SetRecyclerVars()
    {
        snapHelper = new PagerSnapHelper();
        recyclerView = findViewById(R.id.trending_rec);
        trendingList = new ArrayList<>();
        adapter = new TrendingAdapter(trendingList, this);

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
                        startActivity(new Intent(TrendingActivity.this, MainActivity.class));
                        break;
                    case R.id.movies:
                        startActivity(new Intent(TrendingActivity.this, MovieOptions.class));
                        break;
                    case R.id.tvseries:
                        startActivity(new Intent(TrendingActivity.this, TVOptions.class));
                        break;
                    case R.id.search:
                        startActivity(new Intent(TrendingActivity.this, SearchMovies.class));
                        break;
                    case R.id.trend:
                        startActivity(new Intent(TrendingActivity.this, TrendingActivity.class));
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
