package com.jannahsoftware.moviedb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.toolbox.Volley;
import com.jannahsoftware.Application.App;
import com.jannahsoftware.Constants.Conts;
import com.jannahsoftware.json.MovieDBJSON;
import com.jannahsoftware.json.TVSeriesDBJSON;

public class MainActivity extends AppCompatActivity
{

    private MovieDBJSON movieDBJSON = new MovieDBJSON();
    private TVSeriesDBJSON tvSeriesDBJSON = new TVSeriesDBJSON();
    public static String myKey;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myKey = getResources().getString(R.string.apikey);
        Log.d("APIKEY", "onCreate: " + App.key);
        Conts.requestQueue = Volley.newRequestQueue(this);

       // movieDBJSON.GetAllPopularMovies();
        //movieDBJSON.GetUpcomingMovies();
        //movieDBJSON.GetTopRatedMovies();
        //movieDBJSON.GetNowPlayingMovies();
        //movieDBJSON.GetLatestMovies();
        movieDBJSON.SearchMovies();


        //tvSeriesDBJSON.GetAllPopularTVSeries();
        //tvSeriesDBJSON.GetNowPlayingTVSeries();
        //tvSeriesDBJSON.GetAiringTodayTVSeries();
        //tvSeriesDBJSON.GetTopRatedTVSeries();
        //tvSeriesDBJSON.GetLatestTVSeries();
        //tvSeriesDBJSON.SearchTVSeries();


    }
}
