package com.example.marcin.mojtest;


public class Result implements Comparable {

    String poster_path;

    public Result(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getposter_path() {
        return poster_path;
    }

    public void setposter_path(String poster_path) {
        this.poster_path = poster_path;
    }

    @Override
    public int compareTo(Object another) {
        return 0;
    }
}
