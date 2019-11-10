package com.jannahsoftware.NetWork;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jannahsoftware.Gifs.SplashScreen;

public class CheckInternet extends AppCompatActivity
{
    ConnectivityManager cm;
    NetworkInfo info;
    Context context;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context.getApplicationContext();

        cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        info = cm.getActiveNetworkInfo();
    }

    public void GetConnection()
    {
        if(info != null && info.isConnectedOrConnecting())
        {
            startActivity(new Intent(this, SplashScreen.class));
            Log.d("CONN", "GetConnection: " + "Connected");
        }else
        {
            (context).startActivity(new Intent(this, SplashScreen.class));
            Log.d("CONN", "GetConnection: " + "No Connected");
        }
    }
}
