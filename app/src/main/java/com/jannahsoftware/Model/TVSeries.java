package com.jannahsoftware.Model;

public class TVSeries
{
    private double popularity;
    private long vote_count;
    private boolean video;
    private String poster_path;
    private long id;
    private boolean adult;
    private String backdrop_path;
    private String origial_lang;
    private String name;
    private String original_name;
    private int vote_average;
    private String overview;
    private String first_air_date;

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public long getVote_count() {
        return vote_count;
    }

    public void setVote_count(long vote_count) {
        this.vote_count = vote_count;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getOrigial_lang() {
        return origial_lang;
    }

    public void setOrigial_lang(String origial_lang) {
        this.origial_lang = origial_lang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public int getVote_average() {
        return vote_average;
    }

    public void setVote_average(int vote_average) {
        this.vote_average = vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public TVSeries() {
    }

    public TVSeries(double popularity, long vote_count, boolean video, String poster_path, long id, boolean adult, String backdrop_path, String origial_lang, String name, String original_name, int vote_average, String overview, String first_air_date) {
        this.popularity = popularity;
        this.vote_count = vote_count;
        this.video = video;
        this.poster_path = poster_path;
        this.id = id;
        this.adult = adult;
        this.backdrop_path = backdrop_path;
        this.origial_lang = origial_lang;
        this.name = name;
        this.original_name = original_name;
        this.vote_average = vote_average;
        this.overview = overview;
        this.first_air_date = first_air_date;
    }
}
