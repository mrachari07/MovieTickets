package com.movieticket.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {

	    private static final String URL = "jdbc:mysql://localhost:3306/movie_tickets";
	    private static final String USER = "root";
	    private static final String PASSWORD = "root";

	    private DbUtils() {
	    }

	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }
	}
