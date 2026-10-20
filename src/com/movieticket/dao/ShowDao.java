package com.movieticket.dao;
import com.movieticket.util.DbUtils;
import com.movieticket.model.Show;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowDao {
	
	    private static final String SHOW_DETAILS_SQL = "SELECT s.show_id, m.title AS movie_title, t.name AS theater_name, "
	            + "s.show_time, s.ticket_price, s.available_seats "
	            + "FROM shows s JOIN movies m ON s.movie_id = m.movie_id "
	            + "JOIN theaters t ON s.theater_id = t.theater_id ";

	    public void displayAllShows() throws SQLException {
	        try (var connection = DbUtils.getConnection();
	             var statement = connection.prepareStatement(SHOW_DETAILS_SQL + "ORDER BY s.show_time");
	             ResultSet result = statement.executeQuery()) {
	            while (result.next()) {
	                System.out.println(createShow(result));
	            }
	        }
	    }

	    public Show findByIdForUpdate(Connection connection, int showId) throws SQLException {
	        String sql = SHOW_DETAILS_SQL + "WHERE s.show_id = ? FOR UPDATE";
	        try (var statement = connection.prepareStatement(sql)) {
	            statement.setInt(1, showId);
	            try (ResultSet result = statement.executeQuery()) {
	                return result.next() ? createShow(result) : null;
	            }
	        }
	    }

	    public boolean reduceAvailableSeats(Connection connection, int showId, int seats) throws SQLException {
	        String sql = "UPDATE shows SET available_seats = available_seats - ? "
	                + "WHERE show_id = ? AND available_seats >= ?";
	        try (var statement = connection.prepareStatement(sql)) {
	            statement.setInt(1, seats);
	            statement.setInt(2, showId);
	            statement.setInt(3, seats);
	            return statement.executeUpdate() == 1;
	        }
	    }

	    private Show createShow(ResultSet result) throws SQLException {
	        return new Show(result.getInt("show_id"), result.getString("movie_title"),
	                result.getString("theater_name"), result.getTimestamp("show_time").toLocalDateTime(),
	                result.getBigDecimal("ticket_price"), result.getInt("available_seats"));
	    }
	}
