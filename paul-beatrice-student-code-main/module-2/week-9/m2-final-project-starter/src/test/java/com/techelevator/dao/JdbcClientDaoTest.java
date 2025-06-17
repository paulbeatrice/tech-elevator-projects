package com.techelevator.dao;

import com.techelevator.model.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JdbcClientDaoTest {

    private JdbcClientDao clientDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() throws SQLException {
        DataSource dataSource = new SingleConnectionDataSource(
                "jdbc:postgresql://localhost:5432/m2_final_project_test",
                "postgres",
                "postgres1",
                true
        );

        jdbcTemplate = new JdbcTemplate(dataSource);
        clientDao = new JdbcClientDao(jdbcTemplate);

        ScriptUtils.executeSqlScript(dataSource.getConnection(), new org.springframework.core.io.ClassPathResource("test-schema.sql"));
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new org.springframework.core.io.ClassPathResource("test-data.sql"));
    }

    @Test
    void getAllClients_returnsCorrectListSize() {
        List<Client> clients = clientDao.getAllClients();
        assertFalse(clients.isEmpty());
        assertEquals(3, clients.size());
    }

    @Test
    void getClientById_returnsCorrectClient() {
        Client client = clientDao.getClientById(1);
        assertNotNull(client);
        assertEquals("Joe Bob Client Example", client.getName());
    }

    @Test
    void createClient_savesAndReturnsClient() {
        Client newClient = new Client();
        newClient.setName("Joe Dirt Test Client");
        newClient.setEmail("joedirttestclient7@gmail.com");
        newClient.setPhone("333-784-9999");

        Client savedClient = clientDao.createClient(newClient);
        assertNotNull(savedClient);
        assertEquals("Joe Dirt Test Client", savedClient.getName());
    }

    @Test
    void updateClient_updatesClientInfo() {
        Client client = clientDao.getClientById(1);
        assertNotNull(client);

        client.setName("Updated Client Name");
        boolean updated = clientDao.updateClient(client);
        assertTrue(updated);

        Client updatedClient = clientDao.getClientById(1);
        assertNotNull(updatedClient);
        assertEquals("Updated Client Name", updatedClient.getName());
    }

    @Test
    void deleteClient_removesClient() {
        Client client = clientDao.getClientById(1);
        assertNotNull(client);

        boolean isDeleted = clientDao.deleteClient(1);
        assertTrue(isDeleted);

        Client deletedclient = clientDao.getClientById(1);
        assertNull(deletedclient);
    }
}
