package com.movieticket.dao;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BookingDao {

	    public int saveBooking(Connection connection, int showId, String customerName,
	                           int seatsBooked, BigDecimal totalAmount) throws SQLException {
	        String sql = "INSERT INTO bookings (show_id, customer_name, seats_booked, total_amount) "
	                + "VALUES (?, ?, ?, ?)";
	        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	            statement.setInt(1, showId);
	            statement.setString(2, customerName);
	            statement.setInt(3, seatsBooked);
	            statement.setBigDecimal(4, totalAmount);
	            statement.executeUpdate();
	            try (var keys = statement.getGeneratedKeys()) {
	                if (keys.next()) {
	                    return keys.getInt(1);
	                }
	            }
	        }
	        throw new SQLException("Booking could not be saved.");
	    }
	}
