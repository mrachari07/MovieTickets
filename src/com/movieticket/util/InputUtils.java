package com.movieticket.util;

import java.util.Scanner;

public class InputUtils {
	 private InputUtils() {
	    }

	    public static int readInt(Scanner scanner, String prompt) {
	        while (true) {
	            System.out.print(prompt);
	            if (scanner.hasNextInt()) {
	                int value = scanner.nextInt();
	                scanner.nextLine();
	                return value;
	            }
	            System.out.println("Please enter a whole number.");
	            scanner.nextLine();
	        }
	    }

	    public static String readText(Scanner scanner, String prompt) {
	        System.out.print(prompt);
	        return scanner.nextLine();
	    }
}
