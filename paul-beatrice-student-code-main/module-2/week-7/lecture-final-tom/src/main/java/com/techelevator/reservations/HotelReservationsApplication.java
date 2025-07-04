package com.techelevator.reservations;

import com.techelevator.reservations.controller.HotelController;
import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelReservationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelReservationsApplication.class, args);

//        HotelDao hd = new MemoryHotelDao();
//        ReservationDao rd = new MemoryReservationDao(hd);
//        HotelController hc = new HotelController(hd, rd);


    }

}
