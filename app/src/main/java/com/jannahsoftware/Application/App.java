package com.jannahsoftware.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class App extends AppCompatActivity
{
    private static Context context;
    public static String key;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static Context getContext()
    {
        return context;
    }

}
