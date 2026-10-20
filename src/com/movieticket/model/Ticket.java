package com.movieticket.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Ticket {
	
	    private final int bookingId;
	    private final String customerName;
	    private final Show show;
	    private final int seatsBooked;
	    private final BigDecimal totalAmount;
	    private final LocalDateTime bookedAt;

	    public Ticket(int bookingId, String customerName, Show show, int seatsBooked,
	                  BigDecimal totalAmount, LocalDateTime bookedAt) {
	        this.bookingId = bookingId;
	        this.customerName = customerName;
	        this.show = show;
	        this.seatsBooked = seatsBooked;
	        this.totalAmount = totalAmount;
	        this.bookedAt = bookedAt;
	    }

	    public int getBookingId() { return bookingId; }
	    public String getCustomerName() { return customerName; }
	    public Show getShow() { return show; }
	    public int getSeatsBooked() { return seatsBooked; }
	    public BigDecimal getTotalAmount() { return totalAmount; }
	    public LocalDateTime getBookedAt() { return bookedAt; }
	}

