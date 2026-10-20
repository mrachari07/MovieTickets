package com.movieticket.model;

public class Movie {
	  private final int id;
	    private final String title;
	    private final String genre;
	    private final int durationMinutes;

	    public Movie(int id, String title, String genre, int durationMinutes) {
	        this.id = id;
	        this.title = title;
	        this.genre = genre;
	        this.durationMinutes = durationMinutes;
	    }

	    @Override
	    public String toString() {
	        return id + ". " + title + " | " + genre + " | " + durationMinutes + " minutes";
	    }

}
