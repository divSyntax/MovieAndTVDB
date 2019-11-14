package com.jannahsoftware.moviedb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jannahsoftware.Adapters.MovieAdapter;
import com.jannahsoftware.Adapters.SearchMovieAdapter;
import com.jannahsoftware.Constants.Conts;
import com.jannahsoftware.Model.Movie;
import com.jannahsoftware.NetWork.BroadCastReciever;
import com.jannahsoftware.json.MovieDBJSON;
import com.jannahsoftware.json.TVSeriesDBJSON;

import java.util.ArrayList;
import java.util.List;

public class SearchMovies extends AppCompatActivity {

    private MovieDBJSON movieDBJSON = new MovieDBJSON();
    private TVSeriesDBJSON tvSeriesDBJSON = new TVSeriesDBJSON();
    public static String myKey;
    private BroadCastReciever broadCastReciever;
    public static ProgressBar progressBar;

    private FloatingActionButton floatsearchBtn;
    AlertDialog.Builder moviesearch;

    //adapter vars
    public static RecyclerView recyclerView;
    public static RecyclerView.Adapter adapter;
    public static List<Movie> movieList;
    private static LinearLayoutManager linearLayoutManager;
    private SnapHelper snapHelper;

    int clicks = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_movies);

         moviesearch = new AlertDialog.Builder(this);
        floatsearchBtn = findViewById(R.id.searchBtn);

        myKey = getResources().getString(R.string.apikey);
        Conts.requestQueue = Volley.newRequestQueue(this);
        progressBar = findViewById(R.id.bar);

        BottomNav();
        SetRecyclerVars();

        floatsearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popUp();
            }
        });

        setTitle("Search Movies");
    }

    @Override
    protected void onStart() {
        super.onStart();
        //popUp();
    }

    private void popUp()
    {
        final EditText taskEditText = new EditText(SearchMovies.this);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SearchMovies.this);
        alertDialogBuilder.setTitle("Search Movies");
        alertDialogBuilder.setMessage("Example: Harry, Sponge, Ranger...ect");
        alertDialogBuilder.setPositiveButton("Search", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                movieDBJSON.SearchMovies(taskEditText.getText().toString());

                if(SearchMovies.recyclerView.getAdapter().getItemCount() == 0)
                {
                    Toast.makeText(SearchMovies.this, "Sorry, no movie found with that title. Please try again.", Toast.LENGTH_SHORT).show();
                    movieList.clear();
                }else
                {
                    movieList.clear();
                }
            }
        });
        alertDialogBuilder.setView(taskEditText);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void SetRecyclerVars()
    {
        snapHelper = new PagerSnapHelper();
        recyclerView = findViewById(R.id.search_rec);
        movieList = new ArrayList<>();
        adapter = new SearchMovieAdapter(movieList, this);

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
                        startActivity(new Intent(SearchMovies.this, MainActivity.class));
                        break;
                    case R.id.movies:
                        startActivity(new Intent(SearchMovies.this, MovieOptions.class));
                        break;
                    case R.id.tvseries:
                        startActivity(new Intent(SearchMovies.this, TVOptions.class));
                        break;
                    case R.id.search:
                        startActivity(new Intent(SearchMovies.this, SearchMovies.class));
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
