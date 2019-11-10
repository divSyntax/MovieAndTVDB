package com.jannahsoftware.moviedb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MovieOptions extends AppCompatActivity
{
    private ImageView most_popular, up_coming,top_rated, lates_movies, now_playing;
    private TextView most_popularTxt, up_comingTxt,top_ratedTxt, lates_moviesTxt, now_playingTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_options);

        SetUpWidgets();
        ButtonClickEvents();
        TextClickEvants();
        BottomNav();
    }

    private void TextClickEvants()
    {
        //TEXT
        most_popularTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MovieOptions.this,MainActivity.class));
                Toast.makeText(MovieOptions.this, "Clicked.", Toast.LENGTH_SHORT).show();
            }
        });

        up_comingTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MovieOptions.this, "Clicked.", Toast.LENGTH_SHORT).show();
            }
        });

        top_ratedTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MovieOptions.this, "Clicked.", Toast.LENGTH_SHORT).show();
            }
        });

        now_playingTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MovieOptions.this, "Clicked.", Toast.LENGTH_SHORT).show();
            }
        });

        lates_moviesTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MovieOptions.this, "Clicked.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ButtonClickEvents()
    {
        //BUTTONS
        most_popular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MovieOptions.this,MainActivity.class));
                Toast.makeText(MovieOptions.this, "Clicked.", Toast.LENGTH_SHORT).show();
            }
        });

        up_coming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MovieOptions.this, "Clicked.", Toast.LENGTH_SHORT).show();
            }
        });

        top_rated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MovieOptions.this, "Clicked.", Toast.LENGTH_SHORT).show();
            }
        });

        now_playing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MovieOptions.this, "Clicked.", Toast.LENGTH_SHORT).show();
            }
        });

        lates_movies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MovieOptions.this, "Clicked.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void SetUpWidgets()
    {
        most_popular = findViewById(R.id.popular_tv_show_btn);
        up_coming = findViewById(R.id.up_coming_tv_show_btn);
        top_rated = findViewById(R.id.top_rated_tv_show_btn);
        lates_movies = findViewById(R.id.latest_tv_show_btn);
        now_playing = findViewById(R.id.now_airing_tv_show_btn);

        most_popularTxt = findViewById(R.id.popular_movie_txt);
        up_comingTxt = findViewById(R.id.up_coming_movie_txt);
        top_ratedTxt = findViewById(R.id.top_rated_movie_txt);
        lates_moviesTxt = findViewById(R.id.latest_movie_txt);
        now_playingTxt = findViewById(R.id.now_playing_movie_txt);
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
                        startActivity(new Intent(MovieOptions.this, MainActivity.class));
                        break;
                    case R.id.movies:
                        startActivity(new Intent(MovieOptions.this, MovieOptions.class));
                        break;
                    case R.id.tvseries:
                        break;
                    case R.id.search:
                        startActivity(new Intent(MovieOptions.this, SearchMovies.class));
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
