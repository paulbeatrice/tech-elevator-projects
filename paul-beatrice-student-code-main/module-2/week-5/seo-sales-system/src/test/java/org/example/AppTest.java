package org.example;

import dao.JdbcClientDao;
import dao.JdbcOrdersDao;
import dao.JdbcPackageDao;

import model.Client;
import model.Order;
import model.Package;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;




public class AppTest {

    private JdbcClientDao clientDao;
    private JdbcPackageDao packageDao;
    private JdbcOrdersDao ordersDao;

    @BeforeEach
    void setUp() {
        clientDao = new JdbcClientDao();
        packageDao = new JdbcPackageDao();
        ordersDao = new JdbcOrdersDao();
    }

    @Test
    void testViewAllClients() {
        List<Client> clients = clientDao.getClients();
        assertNotNull(clients, "The list of clients should not be null.");
        assertTrue(clients.size() > 0, "The list of clients should not be empty.");
    }

    @Test
    public void testViewAllPackages() {
        List<Package> packages = packageDao.getPackages();
        assertNotNull(packages, "The list of packages should not be null.");
        assertTrue(packages.size() > 0, "The list of packages should not be empty.");
    }

    @Test
    public void testViewAllOrders() {
        List<Order> orders = ordersDao.getOrders();
        assertNotNull(orders, "The list of orders should not be null.");
        assertTrue(orders.size() > 0, "The list of orders should not be empty.");
    }

    @Test
    public void testAddNewClient() {
        Client newClient = new Client(0, "text example", "testexample@yahoo.com", "123-456-7891");
        clientDao.createClient(newClient);

        List<Client> clients = clientDao.getClients();
        boolean clientExists = false;

        for (Client client : clients) {
            if (client.getEmail().equals("testexample@yahoo.com")) {
                clientExists = true;
                break;
            }
        }
        assertTrue(clientExists, "The new client should exist in the database.");
    }

    @Test
    void testAddNewOrder() {

        Client newClient = new Client(0, "test example", "testexample@yahoo.com", "123-456-7891");
        clientDao.createClient(newClient);

        Package newPackage = new Package(0, "Test Package", "Trying to run a test description for the package.", new BigDecimal("899.99"));
        packageDao.createPackage(newPackage);

        Client createdClient = clientDao.getClients().stream()
                .filter(c -> c.getEmail().equals("testexample@yahoo.com"))
                .findFirst()
                .orElse(null);

        Package createdPackage = packageDao.getPackages().stream()
                .filter(p -> p.getName().equals("Test Package"))
                .findFirst()
                .orElse(null);

        assertNotNull(createdClient, "The created client should exist.");
        assertNotNull(createdPackage, "The created package should exist.");

        Order newOrder = new Order(0, createdClient.getClientId(), createdPackage.getPackageId(), "new", new Timestamp(System.currentTimeMillis()));
        ordersDao.createOrder(newOrder);

        List<Order> orders = ordersDao.getOrders();
        boolean orderExists = false;

        for (Order order : orders) {
            if (order.getClientId() == createdClient.getClientId() && order.getPackageId() == createdPackage.getPackageId()) {
                orderExists = true;
                break;
            }
        }

        assertTrue(orderExists, "The new order should now exist in the database.");

    }
}
