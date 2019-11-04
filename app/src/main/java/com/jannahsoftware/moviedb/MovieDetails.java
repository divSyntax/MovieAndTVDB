package com.jannahsoftware.moviedb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

public class MovieDetails extends AppCompatActivity {


    private TextView titleTxt, overviewTxt;
    private ImageView posterImage, backdropImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        titleTxt = findViewById(R.id.details_title);
        overviewTxt = findViewById(R.id.details_overview);

        posterImage = findViewById(R.id.deatails_poster);
        backdropImage = findViewById(R.id.details_backdrop);

        Intent i = getIntent();
        String passedTitle = i.getStringExtra("title");
        String passedOverview = i.getStringExtra("overview");

        String passedPoster = i.getStringExtra("poster");
        String passedbackdrop = i.getStringExtra("backdrop");

        Picasso.get().load(passedPoster).into(posterImage);
        Picasso.get().load(passedbackdrop).into(backdropImage);

        titleTxt.setText(passedTitle);
        overviewTxt.setText(passedOverview);

        BottomNav();
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
                        startActivity(new Intent(MovieDetails.this, MainActivity.class));
                        break;
                    case R.id.movies:
                        startActivity(new Intent(MovieDetails.this, MovieOptions.class));
                        break;
                    case R.id.tvseries:
                        break;
                    case R.id.search:
                        startActivity(new Intent(MovieDetails.this, SearchMovies.class));
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
