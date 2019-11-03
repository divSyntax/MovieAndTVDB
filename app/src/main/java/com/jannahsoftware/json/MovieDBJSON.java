package com.jannahsoftware.json;

import android.util.Log;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.jannahsoftware.Constants.Conts;
import com.jannahsoftware.Model.IMovies;
import com.jannahsoftware.Model.Movie;
import com.jannahsoftware.moviedb.MainActivity;

import org.json.JSONArray;
import org.json.JSONObject;

public class MovieDBJSON implements IMovies
{
    public MovieDBJSON()
    {

    }

    public void GetAllPopularMovies()
    {
        StringRequest getallmovies = new StringRequest(Request.Method.GET, Conts.GET_ALL_POPULAR_MOVIES, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try
                {
                    JSONObject object = new JSONObject(response);
                    JSONArray array  = object.getJSONArray("results");

                    for(int i = 0; i < array.length(); i++)
                    {
                        JSONObject jsonObject = array.getJSONObject(i);

                        Movie getmovies = new Movie();
                        getmovies.setTitle(jsonObject.getString("title"));
                        getmovies.setPoster_path(jsonObject.getString("poster_path"));
                        getmovies.setBackdrop_path(jsonObject.getString("backdrop_path"));

                        MainActivity.movieList.add(getmovies);

                        Log.d("ARRAY", "onResponse: " + jsonObject.getString("title"));
                        Log.d("ARRAY", "onResponse: " + jsonObject.getString("poster_path"));
                    }

                }catch (Exception e)
                {
                    e.printStackTrace();
                }

                MainActivity.adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        Conts.requestQueue.add(getallmovies);
    }

    @Override
    public void GetUpcomingMovies()
    {
        StringRequest getallmovies = new StringRequest(Request.Method.GET, Conts.GET_ALL_UPCOMING_MOVIES, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try
                {
                    JSONObject object = new JSONObject(response);
                    JSONArray array  = object.getJSONArray("results");

                    for(int i = 0; i < array.length(); i++)
                    {
                        JSONObject jsonObject = array.getJSONObject(i);
                        Log.d("ONJ", "onResponse: " + jsonObject.getString("title"));
                    }

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        Conts.requestQueue.add(getallmovies);
    }

    @Override
    public void GetTopRatedMovies()
    {
        StringRequest getallmovies = new StringRequest(Request.Method.GET, Conts.GET_ALL_TOP_RATED_MOVIES, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try
                {
                    JSONObject object = new JSONObject(response);
                    JSONArray array  = object.getJSONArray("results");

                    for(int i = 0; i < array.length(); i++)
                    {
                        JSONObject jsonObject = array.getJSONObject(i);
                        Log.d("RATED", "onResponse: " + jsonObject.getString("title"));
                    }

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        Conts.requestQueue.add(getallmovies);
    }

    @Override
    public void GetNowPlayingMovies()
    {
        StringRequest getallmovies = new StringRequest(Request.Method.GET, Conts.GET_NOW_PLAYING_MOVIES, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try
                {
                    JSONObject object = new JSONObject(response);
                    JSONArray array  = object.getJSONArray("results");

                    for(int i = 0; i < array.length(); i++)
                    {
                        JSONObject jsonObject = array.getJSONObject(i);
                        Log.d("PLAYING", "onResponse: " + jsonObject.getString("title"));
                    }

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        Conts.requestQueue.add(getallmovies);
    }

    @Override
    public void GetLatestMovies()
    {
        JsonObjectRequest getallmovies = new JsonObjectRequest(Request.Method.GET, Conts.GET_LATEST_MOVIES,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try
                {
                    String title = response.getString("title");
                    Log.d("LASTEST", "onResponse:  " + title);

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        Conts.requestQueue.add(getallmovies);
    }

    @Override
    public void SearchMovies()
    {
        StringRequest getallmovies = new StringRequest(Request.Method.GET, Conts.SEARCH_MOVIES, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try
                {
                    JSONObject object = new JSONObject(response);
                    JSONArray array  = object.getJSONArray("results");

                    for(int i = 0; i < array.length(); i++)
                    {
                        JSONObject jsonObject = array.getJSONObject(i);
                        Log.d("PLAYING", "onResponse: " + jsonObject.getString("title"));
                    }

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        Conts.requestQueue.add(getallmovies);
    }
}
