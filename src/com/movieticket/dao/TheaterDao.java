package com.movieticket.dao;
import com.movieticket.util.DbUtils;
import com.movieticket.model.Theater;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TheaterDao {
	 public void displayAllTheaters() throws SQLException {
	        String sql = "SELECT theater_id, name, location FROM theaters ORDER BY theater_id";
	        try (var connection = DbUtils.getConnection();
	             var statement = connection.prepareStatement(sql);
	             ResultSet result = statement.executeQuery()) {
	            while (result.next()) {
	                Theater theater = new Theater(result.getInt("theater_id"), result.getString("name"),
	                        result.getString("location"));
	                System.out.println(theater);
	            }
	        }
	    }

}
