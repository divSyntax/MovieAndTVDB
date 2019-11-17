package com.jannahsoftware.NetWork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jannahsoftware.Gifs.SplashScreen;
import com.jannahsoftware.moviedb.MainActivity;
import com.jannahsoftware.moviedb.R;

public class NoInternet extends AppCompatActivity
{
    private Button internetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_internet);

        internetBtn = findViewById(R.id.checkInternet);

        internetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInternet();
                Log.d("CLIDKED", "onClick: " + "clicked");
            }
        });
    }

    private boolean checkInternet()
    {
            ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnectedOrConnecting()) {
                //Toast.makeText(this, "Connection.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(NoInternet.this, MainActivity.class));
                finish();
                return true;
            } else {
                Toast.makeText(this, "No connection.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(NoInternet.this, NoInternet.class));
                finish();
                return false;
            }

    }
}
