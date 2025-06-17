package com.lendingcatalog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ValetServicesTest {
    private ValetService service;

    @BeforeEach
    void setUp() {
        service = new ValetService() {
            @Override
            public String generateInvoice(String customerName, long durationInHours) {
                return null;
            }
        };
    }

    @Test
    void checkInVehicleTest() throws Exception {
        //1. Arrange
        Customer customer = new Customer("John Smith", "johnsmith@aol.com");
        Vehicle vehicle = new Vehicle("WRX123", "John Smith", "Toyota", "Camry", 2022, "White");

        //2. Act
        service.checkInVehicle(customer, vehicle, 17);

        //3. Assert
        ParkingSpot spot = service.getParkingSpots().get(17);
        assertTrue(spot.isOccupied(), "Parking Spot 17 Should Be Occupied.");
        assertTrue(customer.getVehicles().contains(vehicle), "Vehicle Should Be Added To The Customer");
        assertEquals(1, service.getLogs().size(), "Log Should Contain One Entry.");
        assertTrue(service.getLogs().get(0).contains("Checked In Vehicle"), "Log Entry Should Contain 'Checked In Vehicle' .");
    }
    @Test
    void checkOutVehicleTest() throws Exception {
        Customer customer = new Customer("John Smith", "johnsmith@aol.com");
        Vehicle vehicle = new Vehicle("WRX123", "John Smith", "Toyota", "Camry", 2022, "White");

        service.checkInVehicle(customer, vehicle, 17);

        service.checkOutVehicle(17);

        ParkingSpot spot = service.getParkingSpots().get(17);
        assertFalse(spot.isOccupied(), "Parking Spot 17 should be vacant.");
        assertEquals(2, service.getLogs().size(), "Log Should Contain Two Entries.");
        assertTrue(service.getLogs().get(1).contains("Checked Out Vehicle"), "Log Entry Should Contain 'Checked Out Vehicle' ");

    }

    @Test
    void calculateChargeTest() {
        //Act & Assert
        assertEquals(BigDecimal.valueOf(40), service.calculateCharge(13), "Overnight Rate Should be $40.00.");
        assertEquals(BigDecimal.valueOf(20), service.calculateCharge(4), "4 Hours Should Cost $20.00.");
        assertEquals(BigDecimal.valueOf(10), service.calculateCharge(1), "1 Hour Should Cost $10." );
    }
    @Test
    void displayParkingSpotsTest() {
        //Redirect Console Output for Test
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        //Act
        service.displayParkingSpots();

        //Assert
        String output = outContent.toString();
        assertTrue(output.contains("Spot 1: regular"), "Output should contain spot 1.");
        assertTrue(output.contains("Spot 2: compact"), "Output should contain spot 2.");
        assertTrue(output.contains("(Vacant)"), "Output should indicate spots are vacant by default.");

        //Reset The System.Out
        System.setOut(System.out);
    }
}
