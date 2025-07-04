package com.techelevator.reservations.dao;

import com.techelevator.reservations.model.Address;
import com.techelevator.reservations.model.Hotel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MemoryHotelDao implements HotelDao {

    private List<Hotel> hotels = new ArrayList<>();

    public MemoryHotelDao() {
    	initializeHotelData();
    }

    @Override
    public Hotel getHotelById(int id) {
        for (Hotel hotel : hotels) {
            if (hotel.getId() == id) {
                return hotel;
            }
        }
        return null;
    }

    @Override
    public List<Hotel> getHotels() {
        return Collections.unmodifiableList(hotels);
    }

    @Override
    public List<Hotel> getHotelsByStateAndCity(String state, String city) {

        List<Hotel> filteredHotels = new ArrayList<>();

        if (emptyString(state) && emptyString(city)) {
            return hotels;
        }

        // return hotels that match state
        for (Hotel hotel : hotels) {

            // if city was passed we don't care about the state filter
            if (!emptyString(city)) {
                if (hotel.getAddress().getCity().equalsIgnoreCase(city)) {
                    filteredHotels.add(hotel);
                }
            } else {
                if (hotel.getAddress().getState().equalsIgnoreCase(state)) {
                    filteredHotels.add(hotel);
                }
            }
        }
        return filteredHotels;
    }

    private void initializeHotelData() {
        hotels.add(new Hotel(1,
                "Aloft Cleveland",
                new Address("1111 W 10th St","","Cleveland","Ohio","44115"),
                4,
                48,274));
        hotels.add(new Hotel(2,
                "Hilton Cleveland Downtown",
                new Address("100 Lakeside Ave","","Cleveland","Ohio","44114"),
                4,
                12,287));
        hotels.add(new Hotel(3,
                "Metropolitan at the 9",
                new Address("2017 E 9th St","","Cleveland","Ohio","48226"),
                5,
                22,319));
        hotels.add(new Hotel(4,
                "The Westin Pittsburgh",
                new Address("1000 Penn Ave","","Pittsburgh","Pennsylvania","15222"),
                4,
                60,131));
        hotels.add(new Hotel(5,
                "Hilton Columbus Downtown",
                new Address("401 N High St","","Columbus","Ohio","43215"),
                4,
                34,190));
        hotels.add(new Hotel(6,
                "The Summit A Dolce Hotel",
                new Address("5345 Medpace Way","","Cincinnati","Ohio","43215"),
                4,
                43,218));
        hotels.add(new Hotel(7,
                "Greektown Detroit",
                new Address("1200 St Antoine St","","Detroit","Michigan","48226"),
                4,
                75,185));
    }

    private static boolean emptyString(String s) {
        // Check if a string is null or empty
        return (s == null || s.trim().length() == 0);
    }

}
