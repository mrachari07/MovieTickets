package com.movieticket.model;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Show {
	
	    private final int id;
	    private final String movieTitle;
	    private final String theaterName;
	    private final LocalDateTime showTime;
	    private final BigDecimal ticketPrice;
	    private final int availableSeats;

	    public Show(int id, String movieTitle, String theaterName, LocalDateTime showTime,
	                BigDecimal ticketPrice, int availableSeats) {
	        this.id = id;
	        this.movieTitle = movieTitle;
	        this.theaterName = theaterName;
	        this.showTime = showTime;
	        this.ticketPrice = ticketPrice;
	        this.availableSeats = availableSeats;
	    }

	    public int getId() { return id; }
	    public String getMovieTitle() { return movieTitle; }
	    public String getTheaterName() { return theaterName; }
	    public LocalDateTime getShowTime() { return showTime; }
	    public BigDecimal getTicketPrice() { return ticketPrice; }
	    public int getAvailableSeats() { return availableSeats; }

	    @Override
	    public String toString() {
	        return "Show " + id + " | " + movieTitle + " | " + theaterName + " | "
	                + showTime + " | Rs. " + ticketPrice + " | Seats left: " + availableSeats;
	    }
	}

