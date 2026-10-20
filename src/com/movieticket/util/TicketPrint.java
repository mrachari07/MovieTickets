package com.movieticket.util;

import java.time.format.DateTimeFormatter;

import com.movieticket.model.Ticket;

public class TicketPrint {
	private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a");

    private TicketPrint() {
    }

    public static void print(Ticket ticket) {
        System.out.println("\n========== MOVIE TICKET ==========");
        System.out.println("Booking ID : " + ticket.getBookingId());
        System.out.println("Customer   : " + ticket.getCustomerName());
        System.out.println("Movie      : " + ticket.getShow().getMovieTitle());
        System.out.println("Theater    : " + ticket.getShow().getTheaterName());
        System.out.println("Show time  : " + ticket.getShow().getShowTime().format(FORMAT));
        System.out.println("Seats      : " + ticket.getSeatsBooked());
        System.out.println("Total      : Rs. " + ticket.getTotalAmount());
        System.out.println("Booked at  : " + ticket.getBookedAt().format(FORMAT));
        System.out.println("==================================");
    }

}
