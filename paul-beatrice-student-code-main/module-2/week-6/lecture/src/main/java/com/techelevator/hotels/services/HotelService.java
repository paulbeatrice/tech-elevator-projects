package com.techelevator.hotels.services;

import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Reservation;

public interface HotelService {

    /**
     * List all hotels in the system
     */
    Hotel[] listHotels();

    /**
     * List all reservations in the hotel reservation system
     */
    Reservation[] listReservations();

    /**
     * List all reservations by hotel id.
     */
    Reservation[] listReservationsByHotel(int hotelId);

    /**
     * Find a single reservation by the reservationId
     */
    Reservation getReservation(int reservationId);

    /**
     * Create a new reservation in the hotel reservation system
     */
    Reservation addReservation(Reservation newReservation);

    /**
     * Updates an existing reservation by replacing the old one with a new
     * reservation
     */
    boolean updateReservation(Reservation updatedReservation);

    /**
     * Delete an existing reservation
     */
    boolean deleteReservation(int id);
}
