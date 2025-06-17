package dao;


import model.Client;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JdbcClientDaoTest {
    private static JdbcClientDao clientDao;

    @BeforeAll
    static void setup() {
        clientDao = new JdbcClientDao();
    }

    @Test
    void testCreateClient() {

        Client client = new Client();
        client.setName("John Smith Test");
        client.setEmail("johnsmithtest@gmail.com");
        client.setPhone("123-456-7890");


        clientDao.createClient(client);

        List<Client> clients = clientDao.getClients();
        boolean clientExists = false;
        for (Client c : clients) {
            if (c.getEmail().equals("johnsmithtest@gmail.com")) {
                clientExists = true;
                break;
            }
        }
    assertTrue(clientExists, "The client with email 'johnsmithtest@gmail.com' should exist.");

}

    @Test
    void testDeleteClient() {

        Client client = new Client();
        client.setName("John Smith Test");
        client.setEmail("johnsmithtest@gmail.com");
        client.setPhone("123-456-7890");
        clientDao.createClient(client);

        List<Client> clients = clientDao.getClients();
        Client createdClient = null;
        for (Client c : clients) {
            if (c.getEmail().equals("johnsmithtest@gmail.com")) {
                createdClient = c;
                break;
            }
        }

            assertNotNull(createdClient, "The client we are trying to delete should exist.");
            clientDao.deleteClient(createdClient.getClientId());

            Client deletedClient = clientDao.getClientById(createdClient.getClientId());
            assertNull(deletedClient, "The client should no longer exist after being deleted.");
        }
    }

