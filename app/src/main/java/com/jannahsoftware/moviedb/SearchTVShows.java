package com.jannahsoftware.moviedb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jannahsoftware.Adapters.SearchMovieAdapter;
import com.jannahsoftware.Adapters.SearchTVSeriesAdapter;
import com.jannahsoftware.Constants.Conts;
import com.jannahsoftware.Model.Movie;
import com.jannahsoftware.Model.TVSeries;
import com.jannahsoftware.json.TVSeriesDBJSON;

import java.util.ArrayList;
import java.util.List;

public class SearchTVShows extends AppCompatActivity {

    private TVSeriesDBJSON tvSeriesDBJSON = new TVSeriesDBJSON();
    private FloatingActionButton floatsearchBtn;
    public static String myKey;

    //adapter vars
    public static RecyclerView recyclerView;
    public static RecyclerView.Adapter adapter;
    public static List<TVSeries> tvSeriesList;
    private static LinearLayoutManager linearLayoutManager;
    private SnapHelper snapHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_tvshows);

        floatsearchBtn = findViewById(R.id.searchTVBtn);
        myKey = getResources().getString(R.string.apikey);
        Conts.requestQueue = Volley.newRequestQueue(this);

        BottomNav();
        SetRecyclerVars();

        floatsearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popUp();
            }
        });

        setTitle("Search TV Shows");
    }

    private void SetRecyclerVars()
    {
        snapHelper = new PagerSnapHelper();
        recyclerView = findViewById(R.id.search_rec_tv);
        tvSeriesList = new ArrayList<>();
        adapter = new SearchTVSeriesAdapter(tvSeriesList, this);

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

    private void popUp()
    {
        final EditText taskEditText = new EditText(SearchTVShows.this);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SearchTVShows.this);
        alertDialogBuilder.setTitle("Search TV Series");
        alertDialogBuilder.setMessage("Ex: The Simpsons or Simpsons");
        alertDialogBuilder.setPositiveButton("Search", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                tvSeriesDBJSON.SearchTVSeries(taskEditText.getText().toString());

                if(SearchTVShows.tvSeriesList.size() == 0 && adapter.getItemCount() == 0)
                {
                    Toast.makeText(SearchTVShows.this, "Sorry, no TV Series found with that title. Please try again.", Toast.LENGTH_SHORT).show();
                    tvSeriesList.clear();
                }
            }
        });
        alertDialogBuilder.setView(taskEditText);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
