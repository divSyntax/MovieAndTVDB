package com.jannahsoftware.json;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.jannahsoftware.Constants.Conts;
import com.jannahsoftware.Model.IMovies;
import com.jannahsoftware.Model.Movie;
import com.jannahsoftware.moviedb.LatestMovies;
import com.jannahsoftware.moviedb.MainActivity;
import com.jannahsoftware.moviedb.NowPlayingMovies;
import com.jannahsoftware.moviedb.SearchMovies;
import com.jannahsoftware.moviedb.TopRatedMovies;
import com.jannahsoftware.moviedb.UpComingMovies;

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
                        getmovies.setOverview(jsonObject.getString("overview"));

                        getmovies.setRelease_date(jsonObject.getString("release_date"));
                        getmovies.setVote_average(jsonObject.getInt("vote_average"));
                        getmovies.setPopularity(Math.round(jsonObject.getDouble("popularity")));

                        MainActivity.movieList.add(getmovies);

                        Log.d("ARRAY", "onResponse: " + jsonObject.getString("title"));
                        Log.d("ARRAY", "onResponse: " + jsonObject.getString("poster_path"));
                        Log.d("Overview", "onResponse: " + jsonObject.getString("overview"));

                        Log.d("ARRAY", "onResponse: " + jsonObject.getString("release_date"));
                        Log.d("ARRAY", "onResponse: " + jsonObject.getInt("vote_average"));
                        Log.d("POP", "onResponse: " + Math.round(jsonObject.getDouble("popularity")));
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

                        Movie getmovies = new Movie();

                        getmovies.setTitle(jsonObject.getString("title"));
                        getmovies.setPoster_path(jsonObject.getString("poster_path"));
                        getmovies.setBackdrop_path(jsonObject.getString("backdrop_path"));
                        getmovies.setOverview(jsonObject.getString("overview"));

                        getmovies.setRelease_date(jsonObject.getString("release_date"));
                        getmovies.setVote_average(jsonObject.getInt("vote_average"));
                        getmovies.setPopularity(Math.round(jsonObject.getDouble("popularity")));

                        UpComingMovies.movieList.add(getmovies);

                        Log.d("ARRAY", "onResponse: " + jsonObject.getString("title"));
                        Log.d("ARRAY", "onResponse: " + jsonObject.getString("poster_path"));
                        Log.d("Overview", "onResponse: " + jsonObject.getString("overview"));

                        Log.d("ARRAY", "onResponse: " + jsonObject.getString("release_date"));
                        Log.d("ARRAY", "onResponse: " + jsonObject.getInt("vote_average"));
                        Log.d("POP", "onResponse: " + Math.round(jsonObject.getDouble("popularity")));
                    }

                }catch (Exception e)
                {
                    e.printStackTrace();
                }


                UpComingMovies.adapter.notifyDataSetChanged();

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

                        Movie getmovies = new Movie();

                        getmovies.setTitle(jsonObject.getString("title"));
                        getmovies.setPoster_path(jsonObject.getString("poster_path"));
                        getmovies.setBackdrop_path(jsonObject.getString("backdrop_path"));
                        getmovies.setOverview(jsonObject.getString("overview"));

                        getmovies.setRelease_date(jsonObject.getString("release_date"));
                        getmovies.setVote_average(jsonObject.getInt("vote_average"));
                        getmovies.setPopularity(Math.round(jsonObject.getDouble("popularity")));

                        TopRatedMovies.movieList.add(getmovies);

                        Log.d("ARRAY", "onResponse: " + jsonObject.getString("title"));
                        Log.d("ARRAY", "onResponse: " + jsonObject.getString("poster_path"));
                        Log.d("Overview", "onResponse: " + jsonObject.getString("overview"));

                        Log.d("ARRAY", "onResponse: " + jsonObject.getString("release_date"));
                        Log.d("ARRAY", "onResponse: " + jsonObject.getInt("vote_average"));
                        Log.d("POP", "onResponse: " + Math.round(jsonObject.getDouble("popularity")));
                    }

                }catch (Exception e)
                {
                    e.printStackTrace();
                }

                TopRatedMovies.adapter.notifyDataSetChanged();

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

                        Movie getmovies = new Movie();

                        getmovies.setTitle(jsonObject.getString("title"));
                        getmovies.setPoster_path(jsonObject.getString("poster_path"));
                        getmovies.setBackdrop_path(jsonObject.getString("backdrop_path"));
                        getmovies.setOverview(jsonObject.getString("overview"));

                        getmovies.setRelease_date(jsonObject.getString("release_date"));
                        getmovies.setVote_average(jsonObject.getInt("vote_average"));
                        getmovies.setPopularity(Math.round(jsonObject.getDouble("popularity")));

                        NowPlayingMovies.movieList.add(getmovies);

                        Log.d("ARRAY", "onResponse: " + jsonObject.getString("title"));
                        Log.d("ARRAY", "onResponse: " + jsonObject.getString("poster_path"));
                        Log.d("Overview", "onResponse: " + jsonObject.getString("overview"));

                        Log.d("ARRAY", "onResponse: " + jsonObject.getString("release_date"));
                        Log.d("ARRAY", "onResponse: " + jsonObject.getInt("vote_average"));
                        Log.d("POP", "onResponse: " + Math.round(jsonObject.getDouble("popularity")));
                    }

                }catch (Exception e)
                {
                    e.printStackTrace();
                }

                NowPlayingMovies.adapter.notifyDataSetChanged();

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

                        Movie getmovies = new Movie();

                        getmovies.setTitle(response.getString("title"));
                        getmovies.setPoster_path(response.getString("poster_path"));
                        getmovies.setBackdrop_path(response.getString("backdrop_path"));
                        getmovies.setOverview(response.getString("overview"));

                        getmovies.setRelease_date(response.getString("release_date"));
                        getmovies.setVote_average(response.getInt("vote_average"));
                        getmovies.setPopularity(Math.round(response.getDouble("popularity")));

                        LatestMovies.movieList.add(getmovies);

                        Log.d("ARRAY", "onResponse: " + response.getString("title"));
                        Log.d("ARRAY", "onResponse: " + response.getString("poster_path"));
                        Log.d("Overview", "onResponse: " + response.getString("overview"));

                        Log.d("ARRAY", "onResponse: " + response.getString("release_date"));
                        Log.d("ARRAY", "onResponse: " + response.getInt("vote_average"));
                        Log.d("POP", "onResponse: " + Math.round(response.getDouble("popularity")));


                }catch (Exception e)
                {
                    e.printStackTrace();
                }

                LatestMovies.adapter.notifyDataSetChanged();

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
    public void SearchMovies(String query)
    {
        StringRequest getallmovies = new StringRequest(Request.Method.GET, "https://api.themoviedb.org/3/search/movie?api_key="+ MainActivity.myKey +"&language=en-US&query="+query+"&page=1&include_adult=false", new Response.Listener<String>() {
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
                        getmovies.setOverview(jsonObject.getString("overview"));

                        getmovies.setRelease_date(jsonObject.getString("release_date"));
                        getmovies.setVote_average(jsonObject.getInt("vote_average"));
                        getmovies.setPopularity(Math.round(jsonObject.getDouble("popularity")));


                        SearchMovies.movieList.add(getmovies);

                        Log.d("ARRAY", "onResponse: " + jsonObject.getString("title"));
                        Log.d("ARRAY", "onResponse: " + jsonObject.getString("poster_path"));
                        Log.d("Overview", "onResponse: " + jsonObject.getString("overview"));

                        Log.d("ARRAY", "onResponse: " + jsonObject.getString("release_date"));
                        Log.d("ARRAY", "onResponse: " + jsonObject.getInt("vote_average"));
                        Log.d("POP", "onResponse: " + Math.round(jsonObject.getDouble("popularity")));
                    }

                    SearchMovies.adapter.notifyDataSetChanged();


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
