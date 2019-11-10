package com.jannahsoftware.NetWork;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadCastReciever extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {
        String status = NetWorkUtil.getConnectivity(context);

        if(status.isEmpty())
        {
            status = "No internet.";
            Toast.makeText(context, status, Toast.LENGTH_SHORT).show();
        }else
        {
            status = "Internet.";
            Toast.makeText(context, status, Toast.LENGTH_SHORT).show();
        }
    }
}
