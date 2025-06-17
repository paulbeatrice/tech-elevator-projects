import com.lendingcatalog.Customer;
import com.lendingcatalog.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    private Customer customer;

    @BeforeEach
    void setUp() {
        //Initialize Customer Instance Before Each Test
        customer = new Customer("Joe Dirt", "joedirt@gmail.com");
    }

    @Test
    void testGetName() {
        //Act & Assert
        assertEquals("Joe Dirt", customer.getName(), "Customer Name Should Be 'Joe Dirt'.");
    }
    @Test
    void testGetContactInfo() {
        //Act & Assert
        assertEquals("joedirt@gmail.com", customer.getContactInfo(), "Contact Info Should Be 'joedirt@gmail.com'.");
    }
    @Test
    void getVehicleTest() {
        //Act
        List<Vehicle> vehicles = customer.getVehicles();
        //Assert
        assertNotNull(vehicles, "Vehicle List Should Not Be Null");
        assertTrue(vehicles.isEmpty(), "Vehicle List Should Initially Be Empty.");
    }
    @Test
    void addVehicleTest() {

        Vehicle vehicle = new Vehicle("WRX456", "Joe Dirt", "Kia", "Optima", 2013, "White");

        customer.addVehicle(vehicle);

        List<Vehicle> vehicles = customer.getVehicles();
        assertEquals(1, vehicles.size(), "Vehicle List Should Contain 1 Vehicle After Adding.");
        assertEquals(vehicle, vehicles.get(0), "The Added Vehicle Should Match The Expected Vehicle.");
    }

}
