package com.movieticket.dao;
import com.movieticket.util.DbUtils;
import com.movieticket.model.Movie;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieDao {


	    public void displayAllMovies() throws SQLException {
	        String sql = "SELECT movie_id, title, genre, duration_minutes FROM movies ORDER BY movie_id";
	        try (var connection = DbUtils.getConnection();
	             var statement = connection.prepareStatement(sql);
	             ResultSet result = statement.executeQuery()) {
	            while (result.next()) {
	                Movie movie = new Movie(result.getInt("movie_id"), result.getString("title"),
	                        result.getString("genre"), result.getInt("duration_minutes"));
	                System.out.println(movie);
	            }
	        }
	    }
	}


