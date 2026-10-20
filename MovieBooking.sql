CREATE DATABASE IF NOT EXISTS movie_tickets;
USE movie_tickets;

CREATE TABLE movies (
    movie_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    genre VARCHAR(50) NOT NULL,
    duration_minutes INT NOT NULL
);

CREATE TABLE theaters (
    theater_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(150) NOT NULL
);

CREATE TABLE shows (
    show_id INT PRIMARY KEY AUTO_INCREMENT,
    movie_id INT NOT NULL,
    theater_id INT NOT NULL,
    show_time DATETIME NOT NULL,
    ticket_price DECIMAL(10, 2) NOT NULL,
    available_seats INT NOT NULL,
    CONSTRAINT fk_show_movie FOREIGN KEY (movie_id) REFERENCES movies(movie_id),
    CONSTRAINT fk_show_theater FOREIGN KEY (theater_id) REFERENCES theaters(theater_id)
);

CREATE TABLE bookings (
    booking_id INT PRIMARY KEY AUTO_INCREMENT,
    show_id INT NOT NULL,
    customer_name VARCHAR(100) NOT NULL,
    seats_booked INT NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL,
    booked_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_booking_show FOREIGN KEY (show_id) REFERENCES shows(show_id)
);

INSERT INTO movies (title, genre, duration_minutes) VALUES
('RRR', 'Action', 170),
('Avengers: EndGame', 'Comic', 180),
('Avatar', 'Science Fiction', 160);

INSERT INTO theaters (name, location) VALUES
('ART Cinemas', 'Vanasthalipuram'),
('IMAX', 'City Mall');

INSERT INTO shows (movie_id, theater_id, show_time, ticket_price, available_seats) VALUES
(1, 1, '2026-10-20 18:00:00', 250.00, 80),
(2, 1, '2026-10-20 20:30:00', 300.00, 60),
(3, 2, '2026-10-20 19:00:00', 220.00, 100);
