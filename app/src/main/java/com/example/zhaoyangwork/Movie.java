package com.example.zhaoyangwork;

public class Movie {
    private String title;
    private int year;
    private String genre;
    private int poster;

    // Constructor
    public Movie(String title, int year, String genre, int poster) {
        this.title = title != null ? title : "Unknown Title";
        this.year = year > 0 ? year : 0; // Validate year
        this.genre = genre != null ? genre : "Unknown Genre";
        this.poster = poster; // Poster can be a placeholder if null
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public int getPoster() {
        return poster;
    }
}
