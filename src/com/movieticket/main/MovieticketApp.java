package com.movieticket.main;
import com.movieticket.dao.MovieDao;
import com.movieticket.dao.ShowDao;
import com.movieticket.dao.TheaterDao;
import com.movieticket.service.BookingService;
import com.movieticket.util.InputUtils;
import com.movieticket.util.TicketPrint;
import java.sql.SQLException;
import java.util.Scanner;

public class MovieticketApp {

	    private static final MovieDao movieDao = new MovieDao();
	    private static final TheaterDao theaterDao = new TheaterDao();
	    private static final ShowDao showDao = new ShowDao();
	    private static final BookingService bookingService = new BookingService();

	    public static void main(String[] args) {
	        try (Scanner scanner = new Scanner(System.in)) {
	            boolean running = true;
	            while (running) {
	                printMenu();
	                int choice = InputUtils.readInt(scanner, "Choose an option: ");
	                try {
	                    switch (choice) {
	                        case 1:
	                            movieDao.displayAllMovies();
	                            break;
	                        case 2:
	                            theaterDao.displayAllTheaters();
	                            break;
	                        case 3:
	                            showDao.displayAllShows();
	                            break;
	                        case 4:
	                            bookTicket(scanner);
	                            break;
	                        case 5:
	                            running = false;
	                            System.out.println("Thank you for using Movie Ticket Booking System.");
	                            break;
	                        default:
	                            System.out.println("Please choose an option from 1 to 5.");
	                    }
	                } catch (SQLException exception) {
	                    System.out.println("Database error: " + exception.getMessage());
	                } catch (IllegalArgumentException exception) {
	                    System.out.println("Booking failed: " + exception.getMessage());
	                }
	            }
	        }
	    }

	    private static void bookTicket(Scanner scanner) throws SQLException {
	        System.out.println("\nAvailable shows:");
	        showDao.displayAllShows();
	        int showId = InputUtils.readInt(scanner, "Enter show ID: ");
	        String name = InputUtils.readText(scanner, "Enter your name: ");
	        int seats = InputUtils.readInt(scanner, "How many seats? ");
	        TicketPrint.print(bookingService.bookTicket(showId, name, seats));
	    }

	    private static void printMenu() {
	        System.out.println("\n===== MOVIE TICKET BOOKING =====");
	        System.out.println("1. View movies");
	        System.out.println("2. View theaters");
	        System.out.println("3. View shows");
	        System.out.println("4. Book ticket");
	        System.out.println("5. Exit");
	    }
	}
