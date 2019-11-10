package com.jannahsoftware.NetWork;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

public class NetWorkUtil
{


    public NetWorkUtil()
    {

    }

    public static String getConnectivity(Context context)
    {
        String status = null;

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo != null)
        {
            if(networkInfo.getType() == ConnectivityManager.TYPE_WIFI)
            {
                status = "WiFi Connection.";
                return status;
            }else if(networkInfo.getType() == ConnectivityManager.TYPE_MOBILE)
            {
                status = "Mobile data connection.";
                return status;
            }
        }else
        {
            status = "No connections.";
            return status;
        }

        return status;
    }
}
