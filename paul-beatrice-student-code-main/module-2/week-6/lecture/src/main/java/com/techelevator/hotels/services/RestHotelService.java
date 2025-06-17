package com.techelevator.hotels.services;

import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Reservation;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;


public class RestHotelService implements HotelService {

    private final String API_BASE_URL = "http://localhost:3000/";

    // This is similar to how we used a JdbcTemplate object to send
    // SQL queries/statements
    private final RestClient restClient = RestClient.create(API_BASE_URL);

    /**
     * List all hotels in the system
     */
    public Hotel[] listHotels() {

        Hotel[] hotels = null;

        hotels = restClient.get()
                .uri("hotels")
                .retrieve()
                .body(Hotel[].class);

        return hotels;
    }

    /**
     * List all reservations in the hotel reservation system
     */
    public Reservation[] listReservations() {

        Reservation[] reservations = restClient
                .get()                      // prepare GET request
                .uri("/reservations")       // Endpoint path
                .retrieve()                 // Send request
                .body(Reservation[].class); // Extract the array of reservations from response

        return reservations;
    }

    /**
     * List all reservations by hotel id.
     */
    public Reservation[] listReservationsByHotel(int hotelId) {

        Reservation[] reservations = null;

        reservations = restClient.get()
                .uri("/hotels/" + hotelId + "/reservations")
                .retrieve()
                .body(Reservation[].class);

        return reservations;
    }

    /**
     * Find a single reservation by the reservationId
     */
    public Reservation getReservation(int reservationId) {

        return restClient.get()
                .uri("/reservations/" + reservationId)
                .retrieve()
                .body(Reservation.class);
    }

    /**
     * Create a new reservation in the hotel reservation system
     */
    public Reservation addReservation(Reservation newReservation) {

        return restClient.post()
                .uri("/reservations")
                .contentType(MediaType.APPLICATION_JSON)
                .body(newReservation)
                .retrieve()
                .body(Reservation.class);
    }

    /**
     * Updates an existing reservation by replacing the old one with a new
     * reservation
     */
    public boolean updateReservation(Reservation updatedReservation) {

        boolean updateSuccess = false;

        try {
            restClient.put()
                    .uri("/reservations/" + updatedReservation.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(updatedReservation)
                    .retrieve()
                    .toBodilessEntity();

            updateSuccess = true;

        } catch(RestClientResponseException e){
            // throw exception
        } catch(ResourceAccessException e){
            // throw exception
        }

        return updateSuccess;
    }

    /**
     * Delete an existing reservation
     */
    public boolean deleteReservation(int id) {

        boolean deleteSuccess = false;

        try {
            restClient.delete()
                    .uri("/reservations/" + id)
                    .retrieve()
                    .toBodilessEntity();

            deleteSuccess = true;

        } catch(RestClientResponseException e){
            // throw exception
        } catch(ResourceAccessException e){
            // throw exception
        }

        return deleteSuccess;
    }
}