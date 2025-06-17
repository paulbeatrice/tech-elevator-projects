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

        // Method Chaining
//        String language = " Java SCRIPT!   ";
//        int len = language.toLowerCase().trim().length();
        Hotel[] hotels = null;

        hotels = restClient.get()
                .uri("hotels")
                .retrieve()
                .body(Hotel[].class);  // DEserializes the Hotel JSON data into Java objects (an array of Hotels)

        // Deserialization:  JSON -> Java Objects
        // Serialization: Java Objects -> JSON

        return hotels;
    }

    /**
     * List all reservations in the hotel reservation system
     */
    public Reservation[] listReservations() {

        Reservation[] reservations =
                restClient
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
                //.uri("/hotels/" + hotelId + "/reservations")             // using a Path Variable
                .uri("/reservations?hotelId=" + hotelId)               // using Query String  (same results, given this particular API)
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

        return restClient.post()                            // POST because we're creating
                .uri("/reservations")                   // url: /reservations
                .contentType(MediaType.APPLICATION_JSON)   // request headers (here comes some JSON!)
                .body(newReservation)                      // request body    (put the Java Object in there -> it will automatically serialize it for you!)
                .retrieve()                                //  SEND IT!
                .body(Reservation.class);                  // response body   (automatically deserializes the resulting JSON into a Java Object for you!)
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

            deleteSuccess = true;   // No exception thrown == 2xx response code

        } catch(RestClientResponseException e){   // Got a response, but it was an error (4xx or 5xx)   <--- Getting rejected, Getting rejected
            // throw exception
        } catch(ResourceAccessException e){       // Never got a response at all (like CannotGetJdbcConnection in DAO Weeks)  <--- getting ghosted, your resume went into a black hole
            // throw exception
        }

        return deleteSuccess;
    }
}