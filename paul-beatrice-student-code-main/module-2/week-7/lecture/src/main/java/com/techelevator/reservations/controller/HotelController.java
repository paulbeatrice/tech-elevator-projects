package com.techelevator.reservations.controller;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelController(HotelDao hotelDao, ReservationDao reservationDao) {
        this.hotelDao = hotelDao;
        this.reservationDao = reservationDao;
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
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
        Hotel foundHotel = hotelDao.getHotelById(Integer.parseInt(hotelId));
        return foundHotel;
    }

    /**
     * List of reservations by hotel
     *
     * @param hotelId
     * @return all reservations for a given hotel
     */


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
    public List<Hotel> getHotels(@RequestParam(required = true) String state,
                                 @RequestParam(required = false) String city)
    {
        List<Hotel> hotels = hotelDao.getHotelsByStateAndCity(state, city);
        return hotels;
    }



    /**
     * Returns all reservations in the system
     *
     * @return all reservations
     */


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


    /**
     * Updates a reservation
     *
     * @param reservation
     * @param id
     * @return the updated Reservation
     */


    /**
     * Delete a reservation by id
     *
     * @param id
     */

}
