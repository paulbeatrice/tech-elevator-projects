package com.techelevator.reservations.controller;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    // Dependency Injection
    public HotelController(HotelDao hotelDao, ReservationDao reservationDao) {
        this.hotelDao = hotelDao;
        this.reservationDao = reservationDao;
    }

    //  if you receive a GET requests whose path is "/", run this code!
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String hello() {
        return "Hello World!";
    }




    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.OPTIONS)
    public List<Hotel> hotels(){
        List<Hotel> hotels = hotelDao.getHotels();
        return hotels;
    }


    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{hotelId}", method = RequestMethod.GET)
    public Hotel getHotelById(@PathVariable String hotelId){

        System.out.println("Somebody is asking about hotel #" + hotelId);

        try {
            Hotel foundHotel = hotelDao.getHotelById(Integer.parseInt(hotelId));
            System.out.println("About to send this back to the client: " + foundHotel);

            return foundHotel;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * List of reservations by hotel
     *
     * @param hotelId
     * @return all reservations for a given hotel
     */

    @RequestMapping(path = "/hotels/{hotelId}/reservations", method = RequestMethod.GET)
    public List<Reservation> getReservationsForHotel(@PathVariable Integer hotelId) {
        return reservationDao.getReservationsByHotel(hotelId);
    }


    /**
     * /hotels
     * /hotels?state=ohio
     * /hotels?state=ohio&city=cleveland
     *
     * @param state the state to filter by
     * @param city  the city to filter by
     * @return a list of hotels that match the city & state
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> getHotels(@RequestParam(required = false) String state,
                                 @RequestParam(required = false) String city) {

        List<Hotel> hotels = hotelDao.getHotelsByStateAndCity(state, city);
        return hotels;
    }



    /**
     * Returns all reservations in the system
     *
     * @return all reservations
     */
    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<Reservation> getAllReservations() {
        return reservationDao.getReservations();
    }


    /**
     * Get a reservation by its id
     *
     * @param id
     * @return a single reservation
     */


    /**
     * Create a new reservation for a given hotel
     *
     * @param reservation
     */
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(path = "/reservations", method = RequestMethod.POST)
    public Reservation makeNewRez(@RequestBody Reservation newRez) {
        return reservationDao.createReservation(newRez);
    }


    /**
     * Updates a reservation
     *
     * @param reservation
     * @param id
     * @return the updated Reservation
     */

    // Paths could have multiple path variables, e.g.: /hotels/{hotelId}/reservations/{reservationId}

    @RequestMapping(method = RequestMethod.PUT, path = "/reservations/{reservationId}")
    public Reservation updateReservation(@RequestBody Reservation updatedReservation, @PathVariable(name = "reservationId") int rezId) {

        updatedReservation.setId(rezId); // gives the Path Variable priority over the data inside the Request Body

        Reservation result = reservationDao.updateReservation(updatedReservation);

        if (result == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);   // return a 404 instead the default 200
        }

        return result;
    }


    /**
     * Delete a reservation by id
     *
     * @param id
     */
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(method = RequestMethod.DELETE, path = "/reservations/{id}")
    public int cancelReservation(@PathVariable int id) {

        int rowsAffected = reservationDao.deleteReservationById(id);

        if (rowsAffected == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);  // throws a 404 because the data ain't there
        }

        return rowsAffected;
    }

}
