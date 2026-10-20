package com.movieticket.service;
import com.movieticket.util.DbUtils;
import com.movieticket.dao.BookingDao;
import com.movieticket.dao.ShowDao;
import com.movieticket.model.Show;
import com.movieticket.model.Ticket;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
public class BookingService {

	    private final ShowDao showDao = new ShowDao();
	    private final BookingDao bookingDao = new BookingDao();

	    public Ticket bookTicket(int showId, String customerName, int seatsRequested) throws SQLException {
	        if (customerName == null || customerName.trim().isEmpty()) {
	            throw new IllegalArgumentException("Customer name cannot be empty.");
	        }
	        if (seatsRequested <= 0) {
	            throw new IllegalArgumentException("Number of seats must be greater than zero.");
	        }

	        try (Connection connection = DbUtils.getConnection()) {
	            connection.setAutoCommit(false);
	            try {
	                Show show = showDao.findByIdForUpdate(connection, showId);
	                if (show == null) {
	                    throw new IllegalArgumentException("Show ID not found.");
	                }
	                if (seatsRequested > show.getAvailableSeats()) {
	                    throw new IllegalArgumentException("Only " + show.getAvailableSeats() + " seats are available.");
	                }

	                BigDecimal total = show.getTicketPrice().multiply(BigDecimal.valueOf(seatsRequested));
	                int bookingId = bookingDao.saveBooking(connection, showId, customerName.trim(), seatsRequested, total);
	                if (!showDao.reduceAvailableSeats(connection, showId, seatsRequested)) {
	                    throw new SQLException("Seats were just booked by another user. Please try again.");
	                }

	                connection.commit();
	                return new Ticket(bookingId, customerName.trim(), show, seatsRequested, total, LocalDateTime.now());
	            } catch (SQLException exception) {
	                connection.rollback();
	                throw exception;
	            } catch (IllegalArgumentException exception) {
	                connection.rollback();
	                throw exception;
	            }
	        }
	    }
	}
