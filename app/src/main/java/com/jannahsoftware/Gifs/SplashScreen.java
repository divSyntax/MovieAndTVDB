package com.jannahsoftware.Gifs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.jannahsoftware.NetWork.CheckInternet;
import com.jannahsoftware.NetWork.NoInternet;
import com.jannahsoftware.moviedb.MainActivity;
import com.jannahsoftware.moviedb.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        CheckInternet();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private boolean CheckInternet()
    {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            Toast.makeText(this, "Connection.", Toast.LENGTH_SHORT).show();
            ShowSplashScreen();
            return true;
        } else {
            Toast.makeText(this, "No connection.", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(SplashScreen.this, NoInternet.class));
            finish();
            return false;
        }
    }

    private void ShowSplashScreen()
    {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                Intent mainIntent = new Intent(SplashScreen.this, MainActivity.class);
                SplashScreen.this.startActivity(mainIntent);
                SplashScreen.this.finish();
            }
        },5000);
    }

}
