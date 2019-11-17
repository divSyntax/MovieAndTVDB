package com.jannahsoftware.Constants;
import com.android.volley.RequestQueue;
import com.jannahsoftware.moviedb.MainActivity;
import com.jannahsoftware.moviedb.SearchMovies;

public class Conts
{
    public static RequestQueue requestQueue;
    public static String QuerySearch;

    //MOVIES URL
    public static String GET_ALL_POPULAR_MOVIES = "https://api.themoviedb.org/3/movie/popular?api_key=" + MainActivity.myKey + "&language=en-US&page=1";
    public static String GET_ALL_UPCOMING_MOVIES = "https://api.themoviedb.org/3/movie/upcoming?api_key="+ MainActivity.myKey +"&language=en-US&page=1";
    public static String GET_ALL_TOP_RATED_MOVIES = "https://api.themoviedb.org/3/movie/top_rated?api_key="+ MainActivity.myKey +"&language=en-US&page=1";
    public static String GET_NOW_PLAYING_MOVIES = "https://api.themoviedb.org/3/movie/now_playing?api_key="+ MainActivity.myKey +"&language=en-US&page=1";
    public static String GET_LATEST_MOVIES = "https://api.themoviedb.org/3/movie/latest?api_key="+ MainActivity.myKey +"&language=en-US";
    public  static String SEARCH_MOVIES = "https://api.themoviedb.org/3/search/movie?api_key="+ MainActivity.myKey +"&language=en-US&query=harry&page=1&include_adult=false";

    //Movie URL images
    public static String GET_MOVIE_IMAGES = "https://image.tmdb.org/t/p/w500/";
    public static String GET_MOVIE_BACKDROP = "https://image.tmdb.org/t/p/w780/";


    //TV SERIES URL
    public static String GET_ALL_POPULAR_TVSERVIES = "https://api.themoviedb.org/3/tv/popular?api_key="+ MainActivity.myKey +"&language=en-US&page=1";
    public static String GET_ALL_TV_AIRING_TODAY_TVSERVIES = "https://api.themoviedb.org/3/tv/airing_today?api_key="+ MainActivity.myKey +"&language=en-US&page=1";
    public static String GET_ALL_TOP_RATED_TVSERVIES = "https://api.themoviedb.org/3/tv/top_rated?api_key="+ MainActivity.myKey +"&language=en-US&page=1";
    public static String GET_NOW_PLAYING_TVSERVIES = "https://api.themoviedb.org/3/tv/on_the_air?api_key="+ MainActivity.myKey +"&language=en-US&page=1";
    public static String GET_LATEST_TVSERVIES = "https://api.themoviedb.org/3/tv/latest?api_key="+ MainActivity.myKey +"&language=en-US";
    public static String SEARCH_TVSERIES = "https://api.themoviedb.org/3/search/tv?api_key="+ MainActivity.myKey +"&language=en-US&query=Power%20Ranger&page=1";

    //Get Trending
    public static  String GET_TRENDING_ALL = "https://api.themoviedb.org/3/trending/movie/week?api_key="+MainActivity.myKey+"";


}
